package com.yellowneedle.yellowneedle.data.client

interface MachineLearningClient {

    suspend fun getResponse(input: String): String
}