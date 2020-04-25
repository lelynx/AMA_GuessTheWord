/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.ScoreFragmentBinding

/**
 * Fragment where the final score is shown, after the game is over
 */
class ScoreFragment : Fragment() {

    // 8. Task: Use a ViewModelFactory: création de ces 2 variables
    private lateinit var viewModel:ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.score_fragment,
                container,
                false
        )

        // ATTENTION: Ici, il y 3 façons d’instancier la classe ScoreViewModel.!!
        // 1- on instancie la classe ScoreViewModel, sans utiliser le ScoreViewModelFactory
        viewModel = ScoreViewModel(ScoreFragmentArgs.fromBundle(arguments!!).score)
        // Instancier le ScoreViewModelFactory
        // arguments=getArguments--Return the arguments supplied when the fragment was instantiated, if any.
        // On passe à la factory, en argument, le score que le ViewModel devra enregsitrer
//        viewModelFactory= ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        // 2- on instancie la classe ScoreViewModel, en utilisant la méthode ScoreViewModelFactory#create
//        viewModel=viewModelFactory.create(ScoreViewModel::class.java)
        // 3- on instancie la classe ScoreViewModel, en utilisant ViewModelProviders
        // ATTENTION: la classe ViewModelProviders est dépréciée
//        viewModel=ViewModelProviders.of(this, viewModelFactory).get(ScoreViewModel::class.java)

        // ayant le ViewModel, on peut afficher le score
        binding.scoreText.text=viewModel.score.toString()

        return binding.root
    }
}
