package com.fathooo.myapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.fathooo.myapp.databinding.MainActivityBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.fathooo.myapp.R
import com.fathooo.myapp.controller.CharacterClient
import com.fathooo.myapp.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        val characterAdapter = CharacterAdapter(
            emptyList(),
            object : CharacterClickListener {
                override fun onCharacterClicker(character: Result) {
                    navigateToCharacterId(character)
                }
            }
        )
        binding.recyclerView.adapter = characterAdapter

        lifecycleScope.launch {
            val string_example = getString(R.string.string_example_test)
            Log.d("string_example", string_example)
            val charactersClient = CharacterClient.service.listCharacters()
            val charactersBody = withContext(Dispatchers.IO) { charactersClient.execute().body() }
            if (charactersBody != null) {
                characterAdapter.characters = charactersBody.results
                characterAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun navigateToCharacterId(character: Result) {
        val characterId = character.id
        Log.d("CharacterId", characterId.toString())
        Toast.makeText(this, character.name, Toast.LENGTH_SHORT).show()
        val intel = Intent(this, CharacterActivity::class.java)
        intel.putExtra("characterId", characterId)
        startActivity(intel)

    }
}