package com.aibatech.farmersmarketforsellers.data.repositories

import com.aibatech.farmersmarketforsellers.data.api.ApiService
import com.aibatech.farmersmarketforsellers.data.api.LoginRequest
import com.aibatech.farmersmarketforsellers.data.responses.LoginResponse
import retrofit2.Response

class UserRepository(private val apiService: ApiService) {

    suspend fun login(email: String, password: String): Response<LoginResponse> {
        val loginRequest = LoginRequest(email, password)
        return apiService.login(loginRequest)
    }
}