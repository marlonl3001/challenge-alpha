package br.com.mdr.starwars.domain.repository

import androidx.paging.PagingData
import br.com.mdr.starwars.domain.model.Character
import br.com.mdr.starwars.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllFilms(): Flow<PagingData<Film>>
    fun searchFilms(query: String): Flow<PagingData<Film>>

    fun getAllCharacters(): Flow<PagingData<Character>>
    fun searchCharacters(query: String): Flow<PagingData<Character>>
}
