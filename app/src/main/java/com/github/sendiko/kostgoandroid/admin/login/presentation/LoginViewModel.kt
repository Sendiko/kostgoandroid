package com.github.sendiko.kostgoandroid.admin.login.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailChanged -> TODO()
            is LoginEvent.OnPasswordChanged -> TODO()
            is LoginEvent.OnPasswordVisibilityChanged -> TODO()
            LoginEvent.OnLoginClicked -> TODO()
        }
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