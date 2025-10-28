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

    var uistate = mutableStateOf(SearchResultsUiState())
    private set

    var fetchJob: Job? = null
    fun getFeedSearchByTitle(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByTitle(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByAuthor(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByAuthor(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByAbstract(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByAbstract(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByComment(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByComment(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByJournal(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByJournal(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByCategory(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByCategory(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchByReportNumber(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchByReportNumber(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchById(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchById(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }
    fun getFeedSearchAll(query: String, start: Int, maxResults: Int) {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val arxivFeed = arxivFeedRepository.getFeedSearchAll(query, start, maxResults)
                uistate.value = uistate.value.copy(
                    results = arxivFeed,
                )
            }catch (e: Exception){
                uistate.value = uistate.value.copy(error = "Network Failure")
            }
        }
    }

}
