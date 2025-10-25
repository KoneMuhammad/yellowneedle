package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.source.ArxivFeedNetworkDatSource
import jakarta.inject.Inject

class ArxivFeedNetworkRepository @Inject constructor(private val networkDatSource: ArxivFeedNetworkDatSource) :
    ArxivFeedRepository {
    override suspend fun getArxivFeed(query: String, start: Int, maxResults: Int, ): ArxivFeed {
        /**
         * make return list of arxivFeed
         * save within variable | under the condition that a specific amount is already saved no need for super data ?maybe? see
         * learn the basic ds i use allday
         */
        networkDatSource.getArxivFeed(query, start, maxResults)

    }
}
