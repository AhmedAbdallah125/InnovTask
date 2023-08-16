package com.example.innovtask.data.remote

import android.content.Context
import com.example.core.ResultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream


class MockRemoteSource(val context: Context) : RemoteSource {
    override suspend fun getCoach(): ResultOf<String> {
        // Read the JSON file from the raw resources
withContext(Dispatchers.IO) {
    try {
        val myJsonFile: InputStream = context.resources.assets.open("mock.json")
        val size = myJsonFile.available()
        val buffer = ByteArray(size)
        myJsonFile.read(buffer)
        myJsonFile.close()
        val myJsonData = kotlin.String(buffer, "UTF-8")
        val jsonResponse: MyResponseModel =
            gson.fromJson(myJsonData, MyResponseModel::class.java)
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

