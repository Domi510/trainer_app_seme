package com.codecx.composeui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel pre TimerScreen
 * job - reprezentuje odložené vykonávanie úlohy (task), ktoré môže byť zrušené
 * použitie knižnice Coroutines
 * */
class TimerViewModel : ViewModel() {
    private var job: Job? = null
    private val _time = MutableStateFlow(0) // Timer time in seconds
    val time = _time.asStateFlow()
/**
 * funkcia pre spustenie časovača
 * aktuálny task job - zastavíme/skončíme
 * každú sekundu pomocou delay-u navyšuje hodnotu _time
 * */
    fun startTimer() {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.Default) {
            while (true) {
                delay(1000)
                _time.value += 1
            }
        }
    }
/**
 * Funkcia, ktorá zastaví časovač pomocou pridruženej funkcie .cancel
 * */
    fun stopTimer() {
        job?.cancel()
    }
/**
 * Funkcia, ktorá resetuje časovač
 * funkcia zastaví task a astaví hodnotu času na hodnotu 0
 * */
    fun resetTimer() {
        stopTimer()
        _time.value = 0
    }
}