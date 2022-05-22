package com.sk.rickandmortyapi.network

import com.sk.rickandmortyapi.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    /**
     * Creates a fetch method. Annotate with @GET passing the character path.
     *
     */
    @GET("character")
    suspend fun fetchCharacters(@Query("page") page:String): CharacterResponse

}