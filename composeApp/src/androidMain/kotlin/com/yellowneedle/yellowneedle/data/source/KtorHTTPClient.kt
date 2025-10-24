package com.yellowneedle.yellowneedle.data.source

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import org.simpleframework.xml.core.Persister

class KtorArxivClient: KtorClient {

    private val client = HttpClient()
    private val serializer = Persister()

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

    suspend fun getFeedSearchByTitle(title: String, start: Int = 0, maxResults: Int = 10) =
        get("ti:$title", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }


    suspend fun getFeedSearchByAuthor(author: String, start: Int = 0, maxResults: Int = 10) =
        get("au:$author", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchByAbstract(abs: String, start: Int = 0, maxResults: Int = 10) =
        get("abs:$abs", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchByComment(comment: String, start: Int = 0, maxResults: Int = 10) =
        get("co:$comment", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchByJournal(journal: String, start: Int = 0, maxResults: Int = 10) =
        get("jr:$journal", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchByCategory(cat: String, start: Int = 0, maxResults: Int = 10) =
        get("cat:$cat", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchByReportNumber(rn: String, start: Int = 0, maxResults: Int = 10) =
        get("rn:$rn", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchById(id: String, start: Int = 0, maxResults: Int = 10) =
        get("id:$id", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }

    suspend fun getFeedSearchAll(query: String, start: Int = 0, maxResults: Int = 10) =
        get("all:$query", start, maxResults){
                xml ->
            serializer.read(ArxivFeed::class.java, xml)
        }



}