package com.yellowneedle.yellowneedle.data.source

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import org.simpleframework.xml.core.Persister

class KtorHTTPClient {

    private val client = HttpClient()
    private val serializer = Persister()

    private suspend fun getArxivFeed(query: String, start: Int, maxResults: Int): ArxivFeed {

        val response: HttpResponse =
            client.get("http://export.arxiv.org/api/query?search_query=$query&start=$start&max_results=$maxResults")
        val xmlString: String = response.bodyAsText()
        val feed = serializer.read(ArxivFeed::class.java, xmlString)
        return feed
    }

    suspend fun getFeedSearchByTitle(title: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("ti:$title", start, maxResults)

    suspend fun getFeedSearchByAuthor(author: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("au:$author", start, maxResults)

    suspend fun getFeedSearchByAbstract(abs: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("abs:$abs", start, maxResults)

    suspend fun getFeedSearchByComment(comment: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("co:$comment", start, maxResults)

    suspend fun getFeedSearchByJournal(journal: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("jr:$journal", start, maxResults)

    suspend fun getFeedSearchByCategory(cat: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("cat:$cat", start, maxResults)

    suspend fun getFeedSearchByReportNumber(rn: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("rn:$rn", start, maxResults)

    suspend fun getFeedSearchById(id: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("id:$id", start, maxResults)

    suspend fun getFeedSearchAll(query: String, start: Int = 0, maxResults: Int = 10) =
        getArxivFeed("all:$query", start, maxResults)
}