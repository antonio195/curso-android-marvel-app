package com.antoniocostadossantos.core.usacase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.antoniocostadossantos.core.data.repository.CharactersRepository
import com.antoniocostadossantos.core.domain.model.Character
import com.antoniocostadossantos.core.usacase.GetCharactersUseCase.GetCharactersParams
import com.antoniocostadossantos.core.usacase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetCharactersUseCase {
    operator fun invoke(params: GetCharactersParams): Flow<PagingData<Character>>

    data class GetCharactersParams(val query: String, val pageConfig: PagingConfig)
}

class GetCharactersUseCaseImpl @Inject constructor(
    private val charactersRepository: CharactersRepository
) :
    PagingUseCase<GetCharactersParams, Character>(), GetCharactersUseCase {

    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(config = params.pageConfig) {
            charactersRepository.getCharacters(params.query)
        }.flow
    }

}