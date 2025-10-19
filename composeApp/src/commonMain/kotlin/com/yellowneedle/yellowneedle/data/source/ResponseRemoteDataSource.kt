package com.yellowneedle.yellowneedle.data.source

import me.tatarka.inject.annotations.Inject

@Inject
class ResponseRemoteDataSource(): ResponseDataSource {

    override suspend fun getResponse(instructions: String): String {
        TODO("Not yet implemented")
    }

}
