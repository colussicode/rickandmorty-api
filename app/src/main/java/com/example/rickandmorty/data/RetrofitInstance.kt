package com.example.rickandmorty.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://rickandmortyapi.com/api/")
        .build()
        .create(CharacterService::class.java)
}