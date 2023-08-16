package com.example.core

sealed class ResultOf<out R> {
    data class Success<out T>(val data: T) : ResultOf<T>()
    data class Error(val error: String) : ResultOf<Nothing>()
}