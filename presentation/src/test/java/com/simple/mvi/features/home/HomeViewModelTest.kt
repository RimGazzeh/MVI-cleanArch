package com.simple.mvi.features.home

import com.simple.data.common.Result
import com.simple.data.managers.CharactersManager
import com.simple.domain.entities.Persona
import kotlinx.coroutines.flow.Flow
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    // stub
    private val dataManager: CharactersManager = object : CharactersManager {
        override fun getAllCharacters(): Flow<Result<List<Persona>>> {
            TODO("Not yet implemented")
        }

        override fun searchCharacters(name: String): Flow<Result<List<Persona>>> {
            TODO("Not yet implemented")
        }
    }

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(dataManager)
    }

    @Test
    fun `LoadAllCharacters intent should be interpreted as AllCharacters action`() {
        val action = viewModel.intentToAction(HomeIntent.LoadAllCharacters)
        assertEquals(HomeAction.AllCharacters, action)
    }

    @Test
    fun `ClearSearch intent should be interpreted as AllCharacters action`() {
        val action = viewModel.intentToAction(HomeIntent.ClearSearch)
        assertEquals(HomeAction.AllCharacters, action)
    }

    @Test
    fun `SearchCharacter intent should be interpreted as SearchCharacters action`() {
        val action = viewModel.intentToAction(HomeIntent.SearchCharacter("query"))
        assertEquals(HomeAction.SearchCharacters("query"), action)
    }
}