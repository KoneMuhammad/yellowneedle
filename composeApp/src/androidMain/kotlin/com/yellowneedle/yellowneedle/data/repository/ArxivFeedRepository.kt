package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

interface ArxivFeedRepository {

    suspend fun searchAllAiMlTitle(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchRoboticsTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchArtificialIntelligenceTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchMachineLearningTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchMultiAgentSystemTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchComputerVisionAndPatternRecognitionTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed

    suspend fun searchNaturalLanguageProcessingTitles(query: String, start: Int, maxResults: Int, ): ArxivFeed
}

