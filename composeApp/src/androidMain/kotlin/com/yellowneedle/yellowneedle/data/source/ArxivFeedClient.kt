package com.yellowneedle.yellowneedle.data.source

interface ArxivFeedClient {

    suspend fun <T> get( query: String,
                 start: Int,
                 maxResults: Int,
                 parser: (String) -> T): T
}