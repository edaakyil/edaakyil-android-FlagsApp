package com.edaakyil.app.flags.ui.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.edaakyil.app.flags.data.CountriesData
import com.edaakyil.app.flags.model.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FlagsQuizViewModel : ViewModel() {
    /** Flags Quiz UI state */
    private val _uiState = MutableStateFlow(FlagsQuizUIState())
    val uiState: StateFlow<FlagsQuizUIState> = _uiState.asStateFlow()

    private var usedCountries: MutableSet<Country> = mutableSetOf()
    private lateinit var selectedCountry: Country
    //private lateinit var selectedOptions: Set<String>
    var userGuess by mutableStateOf("")
        private set

    init {
        resetQuiz()
        //Log.i("Model-init", "currentOptions:${_uiState.value.currentOptions}")
        //Log.i("Model-init", "currentCountry:${_uiState.value.currentCountry.name}")
        //Log.i("Model-init", "selectedCountry:${selectedCountry}")
    }

    private fun pickRandomCountry(): Country {
        selectedCountry = CountriesData.southAmericaCountries.random()

        //Log.i("pickRandomCountry", "currentCountry:${_uiState.value.currentCountry.name}")

        return if (usedCountries.contains(selectedCountry)) {
            pickRandomCountry()
        } else {
            usedCountries.add(selectedCountry)
            selectedCountry
        }
    }

    private fun specifyOptions(country: Country): Set<String> {
        /*val randomThree = _uiState.value.continent.countries
            .filter { it.id != _uiState.value.currentCountry.id }
            .shuffled()
            .take(3)*/

        val randomThree = _uiState.value.continent.countries
            .filter { it.id != country.id }
            .shuffled()
            .take(3)

        return (randomThree + country).shuffled().map { it.name }.toSet()
    }

    private fun updateQuizState(updatedScore: Int) {
        _uiState.update { currentState ->
            if (usedCountries.size == _uiState.value.continent.countries.size) {
                currentState.copy(
                    isGameOver = true,
                    isGuessWrong = false,
                    score = updatedScore,
                )
            } else {
                val country = pickRandomCountry()
                val options = specifyOptions(country)

                currentState.copy(
                    score = updatedScore,
                    currentCountry = country,
                    currentOptions = options,
                    currentFlagCount = currentState.currentFlagCount.inc()
                )
            }
        }

        //Log.i("Model-updateQuizState", "currentOptions:${_uiState.value.currentOptions}")
        //Log.i("Model-updateQuizState", "currentCountry:${_uiState.value.currentCountry.name}")
        //Log.i("Model-updateQuizState", "selectedCountry:${selectedCountry}")
    }

    /** Re-initializes the quiz data to restart the quiz. */
    fun resetQuiz() {
        usedCountries.clear()
        val country = pickRandomCountry()
        val options = specifyOptions(country)

        _uiState.value = FlagsQuizUIState(
            currentCountry = country,
            currentOptions = options
        )
    }

    /** Update the user's guess */
    fun updateUserGuess(guessedCountry: String) {
        userGuess = guessedCountry
    }

    /**
     * Checks if the user's guess is correct.
     * Increases the score accordingly.
     */
    fun checkUserGuess() {
        if (userGuess.equals(selectedCountry.name, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.plus(10)
            updateQuizState(updatedScore)
        } else {
            _uiState.update { currentState ->
                currentState.copy(isGuessWrong = true)
            }
        }

        updateUserGuess("")
    }

    /** Skip to next flag */
    fun skipFlag() {
        updateQuizState(_uiState.value.score)

        updateUserGuess("")
    }
}