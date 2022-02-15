package com.example.rickandmorty

data class Character(
    val id: Int,
    val name: String,
    val image: String
)

data class CharacterResult(
    val results: List<Character>?
)