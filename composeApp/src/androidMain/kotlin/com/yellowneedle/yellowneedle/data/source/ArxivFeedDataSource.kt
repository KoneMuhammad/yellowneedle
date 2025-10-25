package com.yellowneedle.yellowneedle.data.source

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

interface ArxivFeedDataSource {

    suspend fun getArxivFeed(
        query: String,
        start: Int,
        maxResults: Int,
    ): ArxivFeed
}






