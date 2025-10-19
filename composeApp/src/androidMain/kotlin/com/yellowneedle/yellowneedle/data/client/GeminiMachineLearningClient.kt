package com.yellowneedle.yellowneedle.data.client

import me.tatarka.inject.annotations.Inject

@Inject
actual class machineLearningClient (): MachineLearningClient{
    override suspend fun getResponse(input: String): String {

    }

}