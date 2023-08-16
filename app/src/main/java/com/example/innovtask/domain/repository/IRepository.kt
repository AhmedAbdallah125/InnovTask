package com.example.innovtask.domain.repository

import com.example.core.ResultOf
import com.example.innovtask.data.model.CoachResponse

interface IRepository {
    suspend fun getCoach(): ResultOf<CoachResponse>
}