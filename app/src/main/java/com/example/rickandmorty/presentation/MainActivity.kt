package com.example.rickandmorty.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.CharacterResult
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterService
import com.example.rickandmorty.data.Repository
import com.example.rickandmorty.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val characterService: CharacterService = RetrofitInstance.retrofit
    private val repository: Repository = Repository(characterService)
    private val presenter: Presenter = Presenter(repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.rv_characters)

        presenter.getCharacterList { characterList ->
            val movieAdapter = CharacterAdapter(characterList!!)
            recyclerView.adapter = movieAdapter
        }

        }
}