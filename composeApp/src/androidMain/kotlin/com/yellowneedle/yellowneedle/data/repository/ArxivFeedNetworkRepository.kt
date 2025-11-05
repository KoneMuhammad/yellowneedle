package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.source.ArxivFeedNetworkDatSource
import jakarta.inject.Inject

class ArxivFeedNetworkRepository @Inject constructor(private val arxivFeedNetworkDatSource: ArxivFeedNetworkDatSource) :
    ArxivFeedRepository {

    override suspend fun searchAllAiMlTitle(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchAllAiMlTitle(query, start, maxResults)

    override suspend fun searchRoboticsTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchRoboticsTitles(query, start, maxResults)

    override suspend fun searchArtificialIntelligenceTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchArtificialIntelligenceTitles(query, start, maxResults)


    override suspend fun searchMachineLearningTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchMachineLearningTitles(query, start, maxResults)

    override suspend fun searchMultiAgentSystemTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchMultiAgentSystemTitles(query, start, maxResults)


    override suspend fun searchComputerVisionAndPatternRecognitionTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchComputerVisionAndPatternRecognitionTitles(query, start, maxResults)


    override suspend fun searchNaturalLanguageProcessingTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed =
        arxivFeedNetworkDatSource.searchNaturalLanguageProcessingTitles(query, start, maxResults)
}

