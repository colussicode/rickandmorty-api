package com.example.rickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.Character
import com.example.rickandmorty.R
import com.example.rickandmorty.presenter.CharacterListContractImpl
import com.example.rickandmorty.presenter.View

class MainActivity : AppCompatActivity(), View {
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val presenter = CharacterListContractImpl.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(presenter)
        presenter.fetchCharacters()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun displayCharacters(list: List<Character>) {
        recyclerView = findViewById(R.id.rv_characters)
        recyclerView.adapter = CharacterAdapter(list)
    }

    override fun displayLoading(isLoading: Boolean) {
        println("Loading $isLoading")
    }

    override fun showError(message: String) {
        println("Erro ao buscar dados na api")
    }
}