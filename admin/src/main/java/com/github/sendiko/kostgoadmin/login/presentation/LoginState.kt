package com.github.sendiko.kostgoadmin.login.presentation

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val message: String = ""
)
