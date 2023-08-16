package com.example.innovtask.data.remote

import com.example.core.ResultOf

interface RemoteSource {
    suspend fun getCoach(): ResultOf<String>

}