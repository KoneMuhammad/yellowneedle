package com.yellowneedle.yellowneedle.data

@Inject
class GeminiMachineLearningClient(private val geminiVertex:): MachineLearningClient{
    override suspend fun getResponse(input: String): String {

    }

}