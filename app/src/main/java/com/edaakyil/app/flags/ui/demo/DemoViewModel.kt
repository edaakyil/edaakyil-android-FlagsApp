package com.edaakyil.app.flags.ui.demo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edaakyil.app.flags.network.MarsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface DemoUiState {
    data class Success(val photos: String) : DemoUiState
    object Error : DemoUiState
    object Loading : DemoUiState
}

class DemoViewModel : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var demoUiState: DemoUiState by mutableStateOf(DemoUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getMarsPhotos() {
        // launch the coroutine using viewModelScope.launch
        viewModelScope.launch {
            // The demoUiState is a mutable state object that represents the status of the most recent web request.
            demoUiState = DemoUiState.Loading
            demoUiState = try {
                val listResult = MarsApi.retrofitService.getPhotos()

                DemoUiState.Success(
                    //photos = "Success: ${listResult.size} Mars photos retrieved"
                    photos = listResult.toString()
                )
            } catch (e: IOException) {
                DemoUiState.Error
            } catch (e: HttpException) {
                DemoUiState.Error
            }
        }
    }
}
