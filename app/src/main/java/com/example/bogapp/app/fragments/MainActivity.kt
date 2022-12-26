package com.example.bogapp.app.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bogapp.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewpager.adapter = adapter

        TabLayoutMediator(tablayout, viewpager){tab, position ->
            when(position){
                0-> tab.text = "Войти"
                1-> tab.text = "Регистрация"
            }
        }.attach()


    }
}