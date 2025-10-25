package com.yellowneedle.yellowneedle.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yellowneedle.yellowneedle.data.dto.ArxivFeed
import com.yellowneedle.yellowneedle.data.repository.ArxivFeedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

data class SearchResultsUiState(val results: ArrayList<ArxivFeed> = ArrayList(), var error: String = "")

@HiltViewModel
class SearchViewModel@Inject constructor(private val arxivFeedRepository: ArxivFeedRepository): ViewModel() {

    var uistate = mutableStateOf(SearchResultsUiState())
    private set

    fun getArxivFeedByTitle(query: String, start: Int, maxResults: Int) {
        viewModelScope.launch {
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

}