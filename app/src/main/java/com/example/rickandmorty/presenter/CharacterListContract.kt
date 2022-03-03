package com.example.rickandmorty.presenter

import androidx.annotation.StringRes
import com.example.rickandmorty.Character
import com.example.rickandmorty.CharacterResult

/*interface CharacterListContract /*: BaseContract */ {*/
interface Presenter /*: BaseContract.Presenter<View>*/ {
    fun fetchCharacters()

    fun attachView(view: View)
}

    interface View /*: BaseContract.View*/ {
        fun displayCharacters(list: List<Character>)

        fun displayLoading(isLoading: Boolean)

        fun showError(message: String)
    }
//}