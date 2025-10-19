package com.yellowneedle.yellowneedle.data.source

interface ResponseDataSource {

    suspend fun getResponse(instructions: String): String
}