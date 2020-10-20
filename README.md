# LiveData

MainActivity

```
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
```

UserViewModel

```
package com.example.empty02.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private var mCurrentName: MutableLiveData<String> = MutableLiveData()
    var contador: Int = 0

    fun getCurrentName(): MutableLiveData<String> {
        return mCurrentName
    }

}
```

LocalizacionObserver

```
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
```

