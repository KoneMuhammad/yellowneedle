package com.yellowneedle.yellowneedle

import kotlin.js.JsModule
import kotlin.js.definedExternally
import kotlin.js.js

@JsModule("firebase/app")
@JsNonModule

external fun initializeApp(config: dynamic): dynamic

@JsModule("" +
        "firebase/ai")
@JsNonModule
external fun getAI(app: dynamic, options: dynamic = definedExternally): dynamic

val firebaseConfig = js("{ apiKey: '...', projectId: '...' }")
val app = initializeApp(firebaseConfig)
val ai = getAI(app)
val model = ai.generativeModel("gemini-2.5-flash")
