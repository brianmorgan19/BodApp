package com.example.bogapp.app.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.bogapp.R
import com.example.bogapp.app.mainScreen.mainScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_registration.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.collections.HashMap

class registration : Fragment(R.layout.fragment_registration) {

    lateinit var auth:FirebaseAuth
    lateinit var fireStore: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        auth = FirebaseAuth.getInstance()
        fireStore = FirebaseFirestore.getInstance()

        auth.signOut()
        val button = view.findViewById<Button>(R.id.btn_createUser)

        button.setOnClickListener {
            createUser()
        }

        return view
    }

    private fun createUser(){
        val user = auth.currentUser
        val name = reg_name.text.toString()
        val email = reg_email.text.toString()
        val password = reg_password.text.toString()

        if(user == null){
        if(email.isNotEmpty() && password.isNotEmpty()  && name.isNotEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                try{
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if(it.isSuccessful){
                            val user = auth.currentUser
                            val userID = user!!.uid
                            val documentReference = fireStore.collection("users").document(userID)

                            val users = HashMap<String, String>()
                            users.put("name", name)
                            users.put("email", email)
                            users.put("password", password)

                            documentReference.set(users)

                            user?.sendEmailVerification()?.addOnSuccessListener {
                                Toast.makeText(activity, "На почту отправлен код с подтверждением.", Toast.LENGTH_LONG).show()
                            }?.addOnFailureListener {
                            Log.d("TAG", "Error: Email not sent" + it.message)
                            }
                            Intent(activity, mainScreen::class.java).also {
                                startActivity(it)
                            }
                        }
                        else{
                            Toast.makeText(activity, "Жопа.", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                catch (e:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        else{
            Toast.makeText(activity, "Все поля должны быть заполнены корректно.", Toast.LENGTH_LONG).show()
        }
    }
        else{
            Toast.makeText(activity, "Введены неверные данные", Toast.LENGTH_LONG).show()
        }
    }
}

