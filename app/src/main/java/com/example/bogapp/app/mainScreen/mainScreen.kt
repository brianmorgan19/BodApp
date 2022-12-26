package com.example.bogapp.app.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bogapp.R
import com.example.bogapp.app.mainScreen.fragments.Dictionary
import com.example.bogapp.app.mainScreen.fragments.Grammar
import com.example.bogapp.app.mainScreen.fragments.test_task
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main_screen.*

class mainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val task_fragment = test_task()
        val dictionary = Dictionary()
        val grammar = Grammar()

        nav.setOnItemSelectedListener {
            it.itemId
        }

    }

    fun setFragmentView(fragment: Fragment){
        val fragment = supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentID, fragment)
            commit()
        }
    }

}