package com.example.empty02.observer

import android.app.Activity
import android.util.Log
import android.util.Log.d
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocalizacionObserver(var activity: Activity) : LifecycleObserver {
//    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateListener(){
        Log.d("TAG", "Estamos en el listener de 1.- onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartListener(){
        Log.d("TAG", "Estamos en el listener de 2.- onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeListener(){
        // TODO: Coprobar los permisos
        // TODO: Recoger la última actualización de la localización
        Log.d("TAG", "Estamos en el listener de 3.- onResume")

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseListener(){
        Log.d("TAG", "Estamos en el listener de onPause")
    }

}