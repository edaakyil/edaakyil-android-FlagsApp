package com.edaakyil.app.flags.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.edaakyil.app.flags.ui.quiz.QuizMenuScreen2
import com.edaakyil.app.flags.ui.theme.FlagsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlagsTheme {
                FlagsApp()
            }
        }
    }
}