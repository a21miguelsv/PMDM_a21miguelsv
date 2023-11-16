package com.example.ud06_3_guessgame

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val words = listOf("Avion", "Cama", "Casa", "Juego")
    var secretWord = words.random().uppercase()
}