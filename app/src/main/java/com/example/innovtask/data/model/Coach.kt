package com.example.innovtask.data.model

import com.google.gson.annotations.SerializedName


data class CoachResponse(
    @SerializedName("coach") var coach: Coach? = Coach()
)

data class Coach(
    @SerializedName("name") var name: String? = null
)