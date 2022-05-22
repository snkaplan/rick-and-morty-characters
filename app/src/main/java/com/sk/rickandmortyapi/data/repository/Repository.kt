package com.sk.rickandmortyapi.data.repository

import com.sk.rickandmortyapi.network.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getCharacters(page: String) = apiService.fetchCharacters(page)
}