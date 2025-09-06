package com.example.shopping.order.model

import com.example.shopping.order.data.ShiprocketLoginRequest
import com.example.shopping.order.data.ShiprocketLoginResponse
import com.example.shopping.order.data.OrderResponse
import javax.inject.Inject

class ShiprocketRepository(
    private val shiprocketApi: ShiprocketApi,
    private val shiprocketTokenManager: ShiprocketTokenManager
){
    suspend fun login(email : String, password : String) : Result<ShiprocketLoginResponse>{
        return try {
            val response = shiprocketApi.login(ShiprocketLoginRequest(email, password))
            if (response.isSuccessful && response.body() != null){
                response.body()!!.token?.let { shiprocketTokenManager.saveToken(it)}
                Result.success(response.body()!!)
            }
            else{
                Result.failure(Exception("Login failed"))
            }
        }
        catch (e : Exception){
            Result.failure(e)
        }
    }

    suspend fun getProtectedData() : Result<String>{
        return try {
            val response = shiprocketApi.getProtectedData()
            if (response.isSuccessful && response.body() != null){
                Result.success(response.body()!!)
            }
            else{
                Result.failure(Exception("Failed to get protected data"))
            }
        }
        catch (e : Exception){
            Result.failure(e)
        }
    }

    suspend fun getOrderById(id : Long) : Result<OrderResponse>{
        return try {
            val response = shiprocketApi.getOrderById(id)
            if (response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            }
            else{
                Result.failure(Exception("Failed to get order by id"))
            }
        }
        catch (e : Exception){
            Result.failure(e)
        }
    }
}