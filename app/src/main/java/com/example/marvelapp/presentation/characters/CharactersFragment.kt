package com.example.marvelapp.presentation.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antoniocostadossantos.core.domain.model.Character
import com.example.marvelapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding: FragmentCharactersBinding get() = _binding!!

    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCharactersBinding.inflate(layoutInflater).apply { _binding = this }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersAdapter()

        charactersAdapter.submitList(
            listOf(
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),
                Character(
                    "Spider Man",
                    "https://tm.ibxk.com.br/2023/10/15/15144301590000.jpg?ims=352x208"
                ),

                )
        )

    }

    private fun initCharactersAdapter() {
        with(binding.recyclerViewCharacters) {
            setHasFixedSize(true)
            adapter = charactersAdapter
        }
    }
}