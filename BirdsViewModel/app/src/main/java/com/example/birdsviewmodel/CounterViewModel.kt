package com.example.birdsviewmodel

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private var counter: Int = 0
    private var background: Int = Color.WHITE

    private var countLiveData = MutableLiveData<Int>()
    private var backgroundLiveData = MutableLiveData<Int>()

    // Bird Count
    fun initialCount(): MutableLiveData<Int> {
        countLiveData.value = counter
        return countLiveData
    }

    fun setCount(Count: Int) {
        this.counter = Count
        countLiveData.value = Count
    }

    fun getCount(): Int {
        return this.counter
    }

    //Color of background
    fun getInitialColor(): MutableLiveData<Int> {
        backgroundLiveData.value = background
        return backgroundLiveData
    }

    fun setColor(color: Int) {
        this.background = color
        backgroundLiveData.value = color
    }

    fun getColor(): Int {
        return this.background
    }
}