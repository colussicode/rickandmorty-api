package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(
    var characterList: List<Character>,
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val characterName: TextView = view.findViewById(R.id.textview_character_name)
        val characterSpecie: TextView = view.findViewById(R.id.textview_character_specie)
        val characterAvatar: ImageView = view.findViewById(R.id.imageview_character_avatar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_item, parent, false)

        return CharacterViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        Glide.with(holder.itemView)
        .load("https://rickandmortyapi.com/api/character/avatar/" + characterList[position].id + ".jpeg")
            .into(holder.characterAvatar)
        holder.characterName.text = characterList[position].name
        holder.characterSpecie.text = characterList[position].species
    }

    override fun getItemCount() = characterList.size
}