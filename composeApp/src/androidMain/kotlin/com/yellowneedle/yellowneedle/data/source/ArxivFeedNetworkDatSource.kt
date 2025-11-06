package com.yellowneedle.yellowneedle.data.source

import android.util.Log
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import org.simpleframework.xml.core.Persister
import javax.inject.Inject

class ArxivFeedNetworkDatSource @Inject constructor(private val client: ArxivFeedClient): ArxivFeedDataSource {

    private val serializer = Persister()

    override suspend fun getArxivFeed(
        query: String,
        start: Int,
        maxResults: Int,
    ): ArxivFeed = client.get(query, start, maxResults) { xml ->
        serializer.read(ArxivFeed::class.java, xml)
    }

    suspend fun searchAllAiMlTitle(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed {
        val categories = listOf("cs.AI", "cs.LG", "cs.MA", "cs.RO", "cs.CV", "cs.CL")
        val categoryQuery = categories.joinToString("+OR+") { "cat:$it" }
        val fullQuery = "($categoryQuery)+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }

    suspend fun searchRoboticsTitles(
        query: String,
        start: Int,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.RO+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }

    suspend fun searchArtificialIntelligenceTitles(
        query: String,
        start: Int ,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.AI+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }
    suspend fun searchMachineLearningTitles(
        query: String,
        start: Int ,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.LG+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }
    suspend fun searchMultiAgentSystemTitles(
        query: String,
        start: Int ,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.MA+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }
    suspend fun searchComputerVisionAndPatternRecognitionTitles(
        query: String,
        start: Int ,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.CV+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }
    // this is (NLP) natural language processing
    suspend fun searchNaturalLanguageProcessingTitles(
        query: String,
        start: Int ,
        maxResults: Int
    ): ArxivFeed {
        val fullQuery = "cat:cs.CL+AND+ti:$query"
        return getArxivFeed(fullQuery, start, maxResults)
    }

}