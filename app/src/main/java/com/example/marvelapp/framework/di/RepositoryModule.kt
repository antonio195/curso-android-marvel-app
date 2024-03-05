package com.example.marvelapp.framework.di

import com.antoniocostadossantos.core.data.repository.CharactersRepository
import com.example.marvelapp.framework.CharactersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCharacterRepository(repository: CharactersRepositoryImpl): CharactersRepository
}