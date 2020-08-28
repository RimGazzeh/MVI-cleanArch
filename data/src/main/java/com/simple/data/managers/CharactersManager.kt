package com.simple.data.managers

import com.simple.data.common.Result
import com.simple.domain.entities.Persona
import kotlinx.coroutines.flow.Flow

/**
 * Created by Rim Gazzah on 8/28/20.
 **/
interface CharactersManager {
    fun getAllCharacters(): Flow<Result<List<Persona>>>
}