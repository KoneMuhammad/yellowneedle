package com.yellowneedle.yellowneedle.data.repository

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed

interface ArxivFeedRepository {

    suspend fun getFeedSearchByTitle(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByAuthor(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByAbstract(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByComment(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByJournal(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByCategory(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchByReportNumber(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchById(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>

    suspend fun getFeedSearchAll(query: String, start: Int, maxResults: Int, ): ArrayList<ArxivFeed>
}

