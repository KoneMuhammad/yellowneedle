package com.yellowneedle.yellowneedle.data.source

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import jakarta.inject.Inject

class ArxivFeedKtorClient@Inject constructor(val client: HttpClient): ArxivFeedClient {
    override suspend fun <T> get(
        query: String,
        start: Int,
        maxResults: Int,
        parser: (String) -> T
    ): T {
            val response: HttpResponse =
                client.get("http://export.arxiv.org/api/query?search_query=$query&start=$start&max_results=$maxResults")
            val xmlString: String = response.bodyAsText()
            return parser(xmlString) // parser handles turning XML into T
    }

}