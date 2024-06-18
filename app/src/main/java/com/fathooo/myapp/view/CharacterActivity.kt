package com.fathooo.myapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.fathooo.myapp.controller.CharacterClient
import com.fathooo.myapp.databinding.ActivityCharacterIdBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class CharacterActivity : ComponentActivity() {

    companion object {
        const val CHARACTER_ID = "characterId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCharacterIdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val characterId = intent.getIntExtra(CHARACTER_ID, 0)
        binding.textTitle.text = characterId.toString()
        lifecycleScope.launch {
            val charactersClient = CharacterClient.service.getCharacter(characterId)
            val charactersBody = withContext(Dispatchers.IO) { charactersClient.execute().body() }
            if (charactersBody != null) {
                Glide.with(binding.root.context).load(charactersBody.image).into(binding.imageCover)
                binding.textTitle.text = charactersBody.name
                val text = "Specie: ${charactersBody.species}\nStatus: ${charactersBody.status}\nGender: ${charactersBody.gender}" +
                        "\nlocation: ${charactersBody.location.name}"
                binding.textDescription.text = text
            }
            }
        }
    }
