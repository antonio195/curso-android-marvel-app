package com.example.marvelapp.presentation.characters

import androidx.paging.PagingData
import com.antoniocostadossantos.core.domain.model.Character
import com.antoniocostadossantos.core.usacase.GetCharactersUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    @ExperimentalCoroutinesApi
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    private val pagingDataCharacters = PagingData.from(
        listOf(
            Character(
                "3D - Man",
                "https://placehold.co/600x400"
            ),
            Character(
                "Spider Man",
                "https://placehold.co/600x400"
            )
        )
    )

    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private lateinit var charactersViewModel: CharactersViewModel

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        charactersViewModel = CharactersViewModel(getCharactersUseCase)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `should validate the paging data object values when calling charactersPagingData`() =
        runBlockingTest {

            whenever(
                getCharactersUseCase.invoke(any())
            ).thenReturn(
                flowOf(pagingDataCharacters)
            )

            val expectedPageData = pagingDataCharacters

            val result = charactersViewModel.charactersPagingData("").first()

            assertEquals(expectedPageData, result)
        }


}