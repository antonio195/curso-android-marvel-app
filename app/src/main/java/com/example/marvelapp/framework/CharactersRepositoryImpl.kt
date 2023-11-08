package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.antoniocostadossantos.core.data.repository.CharactersRemoteDataSource
import com.antoniocostadossantos.core.data.repository.CharactersRepository
import com.antoniocostadossantos.core.domain.model.Character
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
) : CharactersRepository {
    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPaging()
    }
}