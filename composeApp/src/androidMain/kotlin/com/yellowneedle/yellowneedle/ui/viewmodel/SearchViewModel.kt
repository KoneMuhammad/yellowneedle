package com.yellowneedle.yellowneedle.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.repository.ArxivFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

data class SearchResultsUiState(
    val results: ArxivFeed = ArxivFeed(),
    var error: String = ""
)

@HiltViewModel
class SearchViewModel@Inject constructor(private val arxivFeedRepository: ArxivFeedRepository): ViewModel() {

    var uIState = mutableStateOf(SearchResultsUiState())
        private set

    var fetchJob: Job? = null
    fun getFeedSearchAllAiMlTitle(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchAllAiMlTitle(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }
    suspend fun loadNextPage(usersQuery: String) {
        val currentArxivFeed = uIState.value.results
        val offset = currentArxivFeed.entries.size

        try {
            val nextPage = arxivFeedRepository.searchAllAiMlTitle(
                query = usersQuery,
                start = offset,
                maxResults = 50
            )
            val mergedEntries = (currentArxivFeed.entries + nextPage.entries).toMutableList()

            val mergedFeed = currentArxivFeed.copy(entries = mergedEntries)

            uIState.value = uIState.value.copy(results = mergedFeed)
        } catch (e: Exception) {
            uIState.value = uIState.value.copy(error = "Failed to load more results")
        }
    }

    fun getFeedSearchRoboticsTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchRoboticsTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,


                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }

    fun getFeedSearchArtificialIntelligenceTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchArtificialIntelligenceTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }

    fun getFeedSearchMachineLearningTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchMachineLearningTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }

    fun getFeedSearchMultiAgentSystemTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchMultiAgentSystemTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }

    fun getFeedSearchComputerVisionAndPatternRecognitionTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchComputerVisionAndPatternRecognitionTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }

    fun getFeedSearchNaturalLanguageProcessingTitles(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.searchNaturalLanguageProcessingTitles(query, start, maxResults)
                uIState.value = uIState.value.copy(
                    results = arxivFeed,
                )
            } catch (e: Exception) {
                uIState.value = uIState.value.copy(error = "Network Failure")
            }
        }
    }
}