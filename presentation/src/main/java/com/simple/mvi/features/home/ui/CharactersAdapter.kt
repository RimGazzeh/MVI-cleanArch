package com.simple.mvi.features.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.simple.domain.entities.Persona
import com.simple.mvi.databinding.ViewHolderCharacterBinding


class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder>() {
    private var charactersList: List<Persona> = ArrayList()

    class CharactersViewHolder(private val binding: ViewHolderCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindCharacters(character: Persona) {
            with(character) {
                binding.name.text = name
                binding.image.load(image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val itemView = ViewHolderCharacterBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(itemView)
    }

    override fun getItemCount(): Int = charactersList.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindCharacters(charactersList[position])
    }

    fun updateList(characterList: List<Persona>) {
        charactersList = characterList
        notifyDataSetChanged()
    }
}