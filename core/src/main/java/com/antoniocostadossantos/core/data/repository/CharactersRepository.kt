package com.antoniocostadossantos.core.data.repository

import androidx.paging.PagingSource
import com.antoniocostadossantos.core.domain.model.Character

interface CharactersRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>

}