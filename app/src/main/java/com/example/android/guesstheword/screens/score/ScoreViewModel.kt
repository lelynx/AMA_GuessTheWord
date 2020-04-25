package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

// finalScore est un paramètre, mais n'est pas une propriété
class ScoreViewModel(finalScore:Int):ViewModel() {
    val score=finalScore
    init{
     Log.d("ScoreViewModel", "ScoreViewModel created")
    }

}