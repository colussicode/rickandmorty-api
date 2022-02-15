package com.example.rickandmorty

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_characters)

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
                response.body().let {
                    val movieAdapter = CharacterAdapter(it?.results!!)
                    recyclerView.adapter = movieAdapter
                }
            }

            override fun onFailure(call: Call<CharacterResult>, t: Throwable) {
                println(t.message)
            }
        })
        }
}