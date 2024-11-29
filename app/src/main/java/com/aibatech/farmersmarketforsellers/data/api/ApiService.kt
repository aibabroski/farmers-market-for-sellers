package com.aibatech.farmersmarketforsellers.data.api

import com.aibatech.farmersmarketforsellers.data.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("api/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}