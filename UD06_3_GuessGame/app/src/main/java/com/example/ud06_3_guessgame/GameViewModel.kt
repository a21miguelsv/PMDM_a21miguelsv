package com.example.ud06_3_guessgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val words = listOf("Avion", "Cama", "Casa", "Juego")
    var secretWord = words.random().uppercase()
    var secretWordDisplay = MutableLiveData<String>()
    var lives = MutableLiveData<Int>(5)
    var guesses = mutableListOf<Char>()

    init {
        secretWord = generateWordDisplay()
    }
    fun generateWordDisplay() =
        secretWord.map {
            if (it in guesses) it
                else "_"
        }.joinToString("")

    fun game(guess : Char){
        guesses.add(guess.uppercaseChar())
        secretWordDisplay.value = generateWordDisplay()
        if (secretWord.contains(guess.uppercaseChar())) lives.value?.minus(1)
    }
    fun win() = secretWord.equals(secretWordDisplay)
    fun lost() = lives.value?:0<=0

    fun resultMessage() =
        if(win())"Ganaste. La palabra secreta era $secretWord"
        else "Perdiste. La palabra secreta era $secretWord"

    fun restart(){
        guesses.clear()
        lives.value = 5
        secretWord = words.random().uppercase()
        secretWordDisplay.value = generateWordDisplay()
    }
}