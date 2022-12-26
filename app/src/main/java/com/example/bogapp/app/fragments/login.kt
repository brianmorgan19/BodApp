package com.example.bogapp.app.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.bogapp.R
import com.example.bogapp.app.mainScreen.mainScreen
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class login : Fragment(R.layout.fragment_login) {

    lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        auth = FirebaseAuth.getInstance()
        auth.setLanguageCode("ru")
        val btn = view.findViewById<Button>(R.id.btn_loginUser)

        val forgot_pass = view.findViewById<TextView>(R.id.forgot_pass)
        forgot_pass.setOnClickListener {

        }


        btn.setOnClickListener {
            login()
        }

        return view
    }

    private fun login(){
        val email = login_email.text.toString()
        val password = login_password.text.toString()
        val user = auth
        val isExistEmail = user.currentUser?.email
        if(isExistEmail == email){
        if(email.isNotEmpty() && password.isNotEmpty()) {
            CoroutineScope(Dispatchers.IO).launch {
                try{
                    auth.signInWithEmailAndPassword(email, password).await()
                    Intent(activity, mainScreen::class.java).also {
                        startActivity(it)
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
            Toast.makeText(activity, "Заполните все поля!", Toast.LENGTH_LONG).show()
        }
    }
        else{
            Toast.makeText(activity, "Такого пользователя не существует!", Toast.LENGTH_LONG).show()
        }
    }
    }
