package org.zxconnect.android.graphql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class MyViewModel : ViewModel() {
    private val _counter = MutableLiveData<Int>().apply {
        value = 0
    }

    val counter: LiveData<Int>
        get() = _counter


    fun increase() {
        _counter.value = counter.value?.plus(1)
    }

    fun decrease() {
        _counter.value = counter.value?.minus(1)
    }
}
