package com.example.marvelapp.framework.paging

import android.accounts.NetworkErrorException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.antoniocostadossantos.core.data.repository.CharactersRemoteDataSource
import com.antoniocostadossantos.core.domain.model.Character
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.network.response.toCharacterModel

class CharactersPagingSource(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>,
    private val query: String
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val offset = params.key ?: 0
            val queries = hashMapOf("offset" to offset.toString())
//            if (queries.isNotEmpty()) {
//                queries["nameStartsWith"] = query
//            }

            val response = remoteDataSource.fetchCharacters(queries)
            val responseOffSet = response.data.offset
            val totalCharacters = response.data.total

            LoadResult.Page(
                data = response.data.results.map { it.toCharacterModel() },
                prevKey = null,
                nextKey = if (responseOffSet < totalCharacters) {
                    responseOffSet + LIMIT
                } else null
            )
        } catch (e: NetworkErrorException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}
