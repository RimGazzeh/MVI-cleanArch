package com.simple.data.services

import com.simple.data.common.KEY_NAME
import com.simple.data.common.PATH_CHARACTER
import com.simple.domain.dto.ECharacters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Rim Gazzah on 8/19/20.
 **/
interface ApiService {

    @GET(PATH_CHARACTER)
    suspend fun getAllCharacters(): Response<ECharacters>

    @GET(PATH_CHARACTER)
    suspend fun searchCharacterByName(@Query(KEY_NAME) name: String) : Response<ECharacters>

}