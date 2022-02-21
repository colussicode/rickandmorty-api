package com.example.rickandmorty.data

import com.example.rickandmorty.CharacterResult
import retrofit2.Call

class Repository(private val apiInterface: CharacterService) {
    fun fetchCharacterList() : Call<CharacterResult> {
        return apiInterface.getCharacters()
    }
}