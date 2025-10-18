package com.yellowneedle.yellowneedle.data

interface MachineLearningClient {

    suspend fun getResponse(input: String): String
}