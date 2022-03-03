package com.example.rickandmorty.model

import com.example.rickandmorty.CharacterResult
import retrofit2.http.GET

interface CharacterService {
    @GET("character")
    suspend fun getCharacters() : CharacterResult
}