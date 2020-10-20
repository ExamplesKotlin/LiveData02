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