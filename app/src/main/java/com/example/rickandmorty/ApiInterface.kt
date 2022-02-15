package com.example.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("character")
    fun getCharacters() : Call<CharacterResult>
}