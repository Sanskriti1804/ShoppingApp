package com.example.shopping.startup.data

//generic result wrapper - represnts different states of an operation
//out - covariant type - safe for returning values // T= generic data type
sealed class Result<out T> {
    data class Success<out T>(val data : T) : Result<T>()
    data class Error(val message : String) : Result<Nothing>()      //nothing - datatype - returns nothing
    object Loading : Result<Nothing>()
}