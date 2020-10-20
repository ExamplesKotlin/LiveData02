package com.example.empty02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.empty02.observer.LocalizacionObserver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(LocalizacionObserver(this))
    }
}