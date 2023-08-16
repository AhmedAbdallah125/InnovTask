package com.example.innovtask.data.remote

import android.content.Context
import com.example.core.ResultOf
import com.example.innovtask.data.model.CoachResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class MockRemoteSource(private val context: Context) : RemoteSource {
    override suspend fun getCoach(): ResultOf<CoachResponse> {

        val inputStream = context.resources.assets.open("mock.json")
        val reader = BufferedReader(InputStreamReader(inputStream))

        val gson = Gson()
        val coach = gson.fromJson(reader, CoachResponse::class.java)

        withContext(Dispatchers.IO) {
            reader.close()
        }

        return ResultOf.Success(coach)
    }
}

