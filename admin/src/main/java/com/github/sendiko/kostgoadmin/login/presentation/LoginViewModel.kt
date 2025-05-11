package com.github.sendiko.kostgoadmin.login.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged -> changeEmail(event.email)
            is LoginEvent.OnPasswordChanged -> changePassword(event.password)
            is LoginEvent.OnPasswordVisibilityChanged -> changePasswordVisibility(event.isPasswordVisible)
            LoginEvent.OnLoginClicked -> login()
        }
    }

    private fun login() {

    }

    private fun changeEmail(email: String) {
        _state.update { it.copy(email = email) }
    }

    private fun changePassword(password: String) {
        _state.update { it.copy(password = password) }
    }

    private fun changePasswordVisibility(isPasswordVisible: Boolean) {
        _state.update { it.copy(isPasswordVisible = isPasswordVisible) }
    }

}