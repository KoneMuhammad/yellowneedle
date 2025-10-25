package com.yellowneedle.yellowneedle.data.dependancyinjection

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