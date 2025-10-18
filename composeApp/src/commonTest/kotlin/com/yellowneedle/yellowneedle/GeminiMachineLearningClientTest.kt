package com.yellowneedle.yellowneedle

import com.yellowneedle.yellowneedle.data.GeminiMachineLearningClient
import kotlinx.coroutines.delay
import kotlin.test.Test


object FakeGeminiMachineLearningClient {

    suspend fun simulateMachineLearningServiceRequest() : String {
        delay(1000)

       return "Resposne from Service Success"
    }
//how to test suspend functions
    //how to make test from inside out
}
class GeminiMachineLearningClientTest {

    @Test
    fun GeminiMachineLearningClient_GetResponse_ResponseSuccessfull() = runTest
    {

    }
}