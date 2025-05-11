package com.github.sendiko.kostgoadmin.login.presentation

sealed interface LoginEvent {
    data class OnEmailChanged(val email: String) : LoginEvent
    data class OnPasswordChanged(val password: String) : LoginEvent
    data class OnPasswordVisibilityChanged(val isPasswordVisible: Boolean) : LoginEvent
    object OnLoginClicked : LoginEvent
}