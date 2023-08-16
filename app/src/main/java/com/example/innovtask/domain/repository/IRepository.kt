package com.example.innovtask.domain.repository

import com.example.core.ResultOf

interface IRepository {
    suspend fun getCoach(): ResultOf<String>
}