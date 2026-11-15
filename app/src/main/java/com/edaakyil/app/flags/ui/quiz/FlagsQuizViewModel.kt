package com.edaakyil.app.flags.ui.quiz

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.edaakyil.app.flags.data.ContinentsData
import com.edaakyil.app.flags.model.Continent
import com.edaakyil.app.flags.model.Country
import com.edaakyil.app.flags.ui.navigation.QuizDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class FlagsQuizViewModel @Inject constructor(handle: SavedStateHandle) : ViewModel() {
    private val continentId: Int = checkNotNull(handle[QuizDestination.continentTypeArg])
    private val continent: Continent = ContinentsData.continentsList[continentId]
    private val countries = continent.countries
    private var usedCountries: MutableSet<Country> = mutableSetOf()
    private lateinit var selectedCountry: Country
    //private lateinit var selectedOptions: Set<String>

    /** Flags Quiz UI state */
    private val _uiState = MutableStateFlow(FlagsQuizUIState(currentCountry = pickRandomCountry()))
    val uiState: StateFlow<FlagsQuizUIState> = _uiState.asStateFlow()
    var userGuess by mutableStateOf("")
        private set

    init {
        resetQuiz()
    }

    private fun pickRandomCountry(): Country {
        selectedCountry = countries.random()

        return if (usedCountries.contains(selectedCountry)) {
            pickRandomCountry()
        } else {
            usedCountries.add(selectedCountry)
            selectedCountry
        }
    }

    private fun specifyOptions(country: Country): Set<String> {
        val randomThree = countries
            .filter { it.id != country.id }
            .shuffled()
            .take(3)

        return (randomThree + country).shuffled().map { it.name }.toSet()
    }

    private fun updateQuizState(updatedScore: Int) {
        _uiState.update { currentState ->
            if (usedCountries.size == countries.size) {
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