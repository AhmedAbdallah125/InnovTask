package com.example.innovtask.data.remote

import com.example.core.ResultOf
import com.example.innovtask.data.model.CoachResponse

interface RemoteSource {
    suspend fun getCoach(): ResultOf<CoachResponse>

}