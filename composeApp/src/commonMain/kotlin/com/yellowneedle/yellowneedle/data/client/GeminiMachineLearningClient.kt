package com.yellowneedle.yellowneedle.data.client

@Inject
class GeminiMachineLearningClient(private val geminiVertex:): MachineLearningClient{
    override suspend fun getResponse(input: String): String {

    }

}