package com.example.mycarsapp.module

import androidx.lifecycle.ViewModel

class AppViewModel: ViewModel() {
    private val _isLoggedIn : Boolean = true
    val isLoggedIn: Boolean get() = _isLoggedIn
}