package com.example.rickandmorty.data

import com.example.rickandmorty.CharacterResult
import retrofit2.Call
import retrofit2.http.GET

interface CharacterService {

    @GET("character")
    fun getCharacters() : Call<CharacterResult>
}