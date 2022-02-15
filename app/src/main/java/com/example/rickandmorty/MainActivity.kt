package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://rickandmortyapi.com/api/")
            .build()
            .create(ApiInterface::class.java)

        val retrofitResponse = retrofit.getCharacters()
        retrofitResponse.enqueue(object : Callback<CharacterResult> {
            override fun onResponse(
                call: Call<CharacterResult>,
                response: Response<CharacterResult>
            ) {
                println(response.body())
            }

            override fun onFailure(call: Call<CharacterResult>, t: Throwable) {
                println(t.message)
            }

        })
        }
}