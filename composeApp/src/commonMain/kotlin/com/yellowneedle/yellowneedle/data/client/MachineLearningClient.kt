package com.yellowneedle.yellowneedle.data.client

expect open class MachineLearningClient {

    suspend fun getResponse(input: String): String
}