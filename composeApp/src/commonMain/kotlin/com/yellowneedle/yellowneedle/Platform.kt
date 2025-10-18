package com.yellowneedle.yellowneedle

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform