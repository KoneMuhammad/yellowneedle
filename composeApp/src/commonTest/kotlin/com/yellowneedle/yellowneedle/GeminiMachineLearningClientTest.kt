package com.yellowneedle.yellowneedle

import com.yellowneedle.yellowneedle.data.source.ResponseDataSource
import com.yellowneedle.yellowneedle.data.source.ResponseRemoteDataSource
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.testCoroutineScheduler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.seconds


object FakeGeminiMachineLearningClient {

    suspend fun simulateMachineLearningServiceRequest() : String {
        delay(1000)

       return "Resposne from Service Success"
    }
//how to make vals more readable
}
@ExperimentalCoroutinesApi
class GeminiMachineLearningClientTest: FunSpec() {
    init {
        coroutineTestScope = true
        test("GeminiMachineLearningClient_GetResponse_ResponseSuccessfull") {

            launch {
               val responseRemoteDataSource: ResponseDataSource =
                   ResponseRemoteDataSource(FakeGeminiMachineLearningClient)
                val result = ResponseRemoteDataSource("")
                assertEquals(result, responseRemoteDataSource)
            }
            testCoroutineScheduler.advanceTimeBy(1.seconds.inWholeMilliseconds)
        }
    }

}