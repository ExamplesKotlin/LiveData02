package com.example.empty02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.empty02.observer.LocalizacionObserver
import com.example.empty02.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mUserViewModel: UserViewModel
//    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
    }

    fun initViewModel() {
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        // Firts  version
        mUserViewModel.contador += 1
        txtTitle.text = mUserViewModel.contador.toString()

        // Second  version
//        txtTitle.text = (++mUserViewModel.contador).toString()
        lifecycle.addObserver(LocalizacionObserver(this))

        // TODO: Crear un observer para actualziar UI
        val nameObserver = Observer<String> {
            txtSubtitle.text = it.toString()
        }
        mUserViewModel.getCurrentName().observe(this, nameObserver)
        btnSender.setOnClickListener {
            mUserViewModel.getCurrentName().setValue("Hola Amigos!! Este es mi contador: ${mUserViewModel.contador}")
        }

    }

}