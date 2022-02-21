package com.example.rickandmorty.presentation

import com.example.rickandmorty.Character
import com.example.rickandmorty.CharacterResult
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val repository: Repository) {
    fun getCharacterList(callback: (List<Character>?) -> Unit) {
        repository.fetchCharacterList().enqueue(object :
            Callback<CharacterResult> {
            override fun onResponse(
                call: Call<CharacterResult>,
                response: Response<CharacterResult>
            ) {
                response.body().let {
                    callback.invoke(it?.results)
                }
            }

            override fun onFailure(call: Call<CharacterResult>, t: Throwable) {
                println(t.message)
            }
        })
    }
}