package com.simple.mvi.features.home

import com.simple.data.common.CallErrors
import com.simple.data.common.Result
import com.simple.domain.entities.Persona
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeReducersTest {

    @Test
    fun `success without search should reduce to ResultAllPersona state`() {
        val data = emptyList<Persona>()
        val result: Result<List<Persona>> = Result.Success(data)

        val state = result.reduce(false)

        assertEquals(HomeState.ResultAllPersona(data), state)
    }

    @Test
    fun `success with search should reduce to ResultSearch state`() {
        val data = emptyList<Persona>()
        val result: Result<List<Persona>> = Result.Success(data)

        val state = result.reduce(true)

        assertEquals(HomeState.ResultSearch(data), state)
    }

    @Test
    fun `error should reduce to Exception state`() {
        val exception = CallErrors.ErrorServer
        val result: Result<List<Persona>> = Result.Error(exception)

        val expected = HomeState.Exception(exception)
        assertEquals(expected, result.reduce(true))
        assertEquals(expected, result.reduce(false))
    }

    @Test
    fun `loading should reduce to Loading state`() {
        val result: Result<List<Persona>> = Result.Loading

        assertEquals(HomeState.Loading, result.reduce(true))
        assertEquals(HomeState.Loading, result.reduce(false))
    }

}