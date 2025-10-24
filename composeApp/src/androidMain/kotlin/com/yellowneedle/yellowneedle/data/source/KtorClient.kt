package com.yellowneedle.yellowneedle.data.source

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

interface KtorClient {

    suspend fun <T> get(
        query: String,
        start: Int,
        maxResults: Int,
        parser: (String) -> T
    ): T
}

fun <T> defaultKtorClient(xyz:(String) -> T) {
    val temp = "doa"
    xyz(temp)
}




