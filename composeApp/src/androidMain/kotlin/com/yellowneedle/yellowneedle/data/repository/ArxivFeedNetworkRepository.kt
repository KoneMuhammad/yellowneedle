package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.source.ArxivFeedNetworkDatSource
import jakarta.inject.Inject

class ArxivFeedNetworkRepository @Inject constructor(private val networkDatSource: ArxivFeedNetworkDatSource) :
    ArxivFeedRepository {

    override suspend fun getFeedSearchByTitle(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByTitle(query, start, maxResults)

    override suspend fun getFeedSearchByAuthor(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByAuthor(query, start, maxResults)

    override suspend fun getFeedSearchByAbstract(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByAbstract(query, start, maxResults)


    override suspend fun getFeedSearchByComment(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByComment(query, start, maxResults)

    override suspend fun getFeedSearchByJournal(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByJournal(query, start, maxResults)


    override suspend fun getFeedSearchByCategory(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByCategory(query, start, maxResults)


    override suspend fun getFeedSearchByReportNumber(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchByReportNumber(query, start, maxResults)


    override suspend fun getFeedSearchById(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchById(query, start, maxResults)


    override suspend fun getFeedSearchAll(
        query: String,
        start: Int,
        maxResults: Int
    ): ArrayList<ArxivFeed> =
        networkDatSource.getFeedSearchAll(query, start, maxResults)

}
