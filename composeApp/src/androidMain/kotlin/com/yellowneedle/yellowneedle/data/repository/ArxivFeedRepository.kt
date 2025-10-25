package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

interface ArxivFeedRepository {

    suspend fun getArxivFeed(  query: String,
                       start: Int,
                       maxResults: Int,): ArxivFeed

    ()
}
