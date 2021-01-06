package com.kmdev.handson.common.fp

sealed class Result<out T> {
    data class OK<T>(val value: T) : Result<T>()
    data class Fail<T>(val cause: String) : Result<T>()
}
