package com.example.counterapp.viewmodel

import androidx.compose.runtime.asIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor() : ViewModel() {
    private var _counter = mutableIntStateOf(0)
    val counter = _counter.asIntState()

    fun increment() {
        _counter.intValue++
    }

    fun decrement() {
        _counter.intValue--
    }

    fun reset() {
        _counter.intValue = 0
    }
}
