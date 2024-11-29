package com.aibatech.farmersmarketforsellers.ui.login

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.aibatech.farmersmarketforsellers.data.repositories.UserRepository
import com.aibatech.farmersmarketforsellers.data.responses.LoginResponse
import retrofit2.Response

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _email = mutableStateOf("")
    val email: State<String> get() = _email

    private val _password = mutableStateOf("")
    val password: State<String> get() = _password

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> get() = _isLoading

    private val _errorMessage = mutableStateOf("")
    val errorMessage: State<String> get() = _errorMessage

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onLogin() {
        if (_email.value.isBlank() || _password.value.isBlank()) {
            _errorMessage.value = "Please fill in both fields."
        } else {
            _isLoading.value = true
            viewModelScope.launch {
                try {
                    val response: Response<LoginResponse> = userRepository.login(_email.value, _password.value)

                    if (response.isSuccessful) {
                        // Handle successful login, e.g. navigate to the dashboard
                    } else {
                        _errorMessage.value = response.message() // Or a custom error message
                    }
                } catch (e: Exception) {
                    _errorMessage.value = "Login failed. Please try again."
                } finally {
                    _isLoading.value = false
                }
            }
        }
    }
}