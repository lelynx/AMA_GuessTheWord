package com.example.android.guesstheword.screens.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

// cette classe a une propriété: finalSCore
// Elle sera instanciée par ScoreFragment
class ScoreViewModelFactory(private val finalScore:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        // on vérifie sie la classe passée en paramètre est de type SCoreViewModel
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            // si oui, on retourne une instance de cette classe, en lui passant le score
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}