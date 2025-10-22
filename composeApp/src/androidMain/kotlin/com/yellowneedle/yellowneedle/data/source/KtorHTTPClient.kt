package com.yellowneedle.yellowneedle.data.source

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class KtorHTTPClient {

    suspend fun getResearchPaperMetaData(userQuery: String): HttpResponse {
        val client = HttpClient()

        val response: HttpResponse = client.get("http://export.arxiv.org/api/query?search_query=all:electron")
        println(response.toString())
        return response

    }
}