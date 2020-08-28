package com.simple.data

import com.simple.domain.dto.ECharacter
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Flow

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
interface ApiService {

    @GET(PATH_CHARACTER)
    suspend fun getAllCharacters(): Response<List<ECharacter>>

    @GET(PATH_CHARACTER)
    suspend fun searchCharacterByName(@Query(KEY_NAME) name: String) : Response<List<ECharacter>>

}