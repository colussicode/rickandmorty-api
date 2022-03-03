package com.example.rickandmorty.presenter

import com.example.rickandmorty.base.LifecycleScope
import com.example.rickandmorty.model.CharacterService
import com.roquebuarque.cpynpasta.model.NetworkModule
import kotlinx.coroutines.launch

class CharacterListContractImpl(private val service: CharacterService)
    : Presenter, LifecycleScope(){

    private var view: View? = null

    override fun fetchCharacters() {
        launch {
            view?.displayLoading(true)
            try {
                val response = service.getCharacters()

                view?.displayLoading(false)
                view?.displayCharacters(response.results)

            }catch (exception: Exception) {
                view?.displayLoading(false)
                view?.showError("Errou em")
            }
        }
    }

    override fun attachView(view: View) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }


    companion object{
        fun create(service: CharacterService = NetworkModule.createNetworkService()): CharacterListContractImpl {
            return CharacterListContractImpl(service)
        }
    }
}