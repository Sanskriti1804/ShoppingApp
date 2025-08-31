package com.example.shopping.order.model

import com.example.shopping.order.data.ShipRocketAuthRequest
import com.example.shopping.order.data.ShipRocketAuthResponse

class ShipRocketRepository (
    private val shipRocketAuthApi: ShipRocketAuthApi
){
    suspend fun login(email : String, password : String) : Result<ShipRocketAuthResponse>{
        return try {
            val response = shipRocketAuthApi.login(ShipRocketAuthRequest(email, password))
            if (response.isSuccessful && response.body() != null){
                Result.success(response.body()!!)
            }
            else{
                Result.failure(Exception("Network request failed"))
            }
        }
        catch (e : Exception){
            Result.failure(e)
        }
    }
}