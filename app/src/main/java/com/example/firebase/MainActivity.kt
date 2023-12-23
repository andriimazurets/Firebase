package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.example.firebase.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder, MainFragment.newInstance())
            .commit()
    }
}