package com.github.sendiko.kostgoadmin.register.presentation

sealed interface RegisterEvent {
    data class OnFullNameChanged(val fullName: String) : RegisterEvent
    data class OnEmailChanged(val email: String) : RegisterEvent
    data class OnPhoneNumberChanged(val phoneNumber: String) : RegisterEvent
    data class OnPasswordChanged(val password: String) : RegisterEvent
    data class OnPasswordVisibilityChanged(val isVisible: Boolean) : RegisterEvent
    object OnRegisterClicked : RegisterEvent
}