package com.fathooo.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fathooo.myapp.databinding.ItemLayoutBinding
import com.fathooo.myapp.model.Result


interface CharacterClickListener{
    fun onCharacterClicker(character: Result)
}

class CharacterAdapter( var characters: List<Result>,
                       private val characterClickListener: CharacterClickListener): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
        holder.itemView.setOnClickListener{characterClickListener.onCharacterClicker(character)}
    }

    class ViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: Result){
            binding.textTitle.text = character.name
//            binding.textDescription.text = character.species
            Glide.with(binding.root.context).load(character.image).into(binding.imageCover)
        }
    }

}