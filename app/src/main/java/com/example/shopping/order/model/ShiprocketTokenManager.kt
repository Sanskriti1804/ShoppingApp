package com.example.shopping.order.model

import android.content.Context

class ShiprocketTokenManager(context : Context){
    private val sharedPreferences = context.getSharedPreferences(
        "ShipRocketToken",
        Context.MODE_PRIVATE
    )

    fun saveToken(token : String){
        sharedPreferences.edit().putString("jwt_token", token).apply()
    }

    fun getToken() : String?{
        return sharedPreferences.getString("jwt_token", null)
    }

    fun clearToken(){
        sharedPreferences.edit().remove("jwt_token").apply()
    }

}