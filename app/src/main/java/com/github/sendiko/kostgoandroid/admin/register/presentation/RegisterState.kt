package com.github.sendiko.kostgoandroid.admin.register.presentation

data class RegisterState(
    val fullName: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val message: String = ""
)
