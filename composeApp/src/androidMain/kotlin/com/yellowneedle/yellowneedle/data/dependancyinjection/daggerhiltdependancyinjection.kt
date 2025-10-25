package com.yellowneedle.yellowneedle.data.dependancyinjection

import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.repository.ArxivFeedNetworkRepository
import com.yellowneedle.yellowneedle.data.repository.ArxivFeedRepository
import com.yellowneedle.yellowneedle.data.source.ArxivFeedClient
import com.yellowneedle.yellowneedle.data.source.ArxivFeedKtorClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKtorApiClient(): HttpClient {
        return HttpClient()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindArxivFeedClientToKtor(impl: ArxivFeedKtorClient): ArxivFeedClient
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    abstract fun bindArxivFeedRepositorytoArxivFeedNetworkRepository(repository: ArxivFeedNetworkRepository): ArxivFeedRepository
}