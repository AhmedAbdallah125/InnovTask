package com.example.innovtask.data.repository

import com.example.core.ResultOf
import com.example.innovtask.data.model.CoachResponse
import com.example.innovtask.data.remote.RemoteSource
import com.example.innovtask.domain.repository.IRepository

class ConcreteRepository(
    val remoteSource: RemoteSource
) : IRepository {
    override suspend fun getCoach(): ResultOf<CoachResponse> {
        return try {
            remoteSource.getCoach()
        } catch (ex: Exception) {
            ResultOf.Error(ex.localizedMessage?:"")
        }
    }
}