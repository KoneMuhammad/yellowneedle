package com.yellowneedle.yellowneedle.dependancymanagement

@Component
abstract class MachineLearningComponent{

    @Provides
    fun addMachineLearningClient :   = addMachineLearningClient()
}