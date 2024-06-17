package com.fathooo.myapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.fathooo.myapp.databinding.MainActivityBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.fathooo.myapp.controller.CharacterClient
import com.fathooo.myapp.model.Characters
import com.fathooo.myapp.model.Result
import kotlin.concurrent.thread

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
                    Toast.makeText(this@MainActivity, character.name, Toast.LENGTH_SHORT).show()
                }
            }
        )
        binding.recyclerView.adapter = characterAdapter

        thread {
            this.resources.getString(R.string.string_example_test)
            val charactersClient = CharacterClient.service.listCharacters()
            val charactersBody = charactersClient.execute().body()
            if (charactersBody != null) {
                Log.d("charactersBody", charactersBody.toString())
                runOnUiThread {
                    characterAdapter.characters = charactersBody.results
                    characterAdapter.notifyDataSetChanged()
//                    binding.recyclerView.adapter = CharacterAdapter(charactersBody.results, object : CharacterClickListener {
//                        override fun onCharacterClicker(character: Result) {
//                            Toast.makeText(this@MainActivity, character.name, Toast.LENGTH_SHORT).show()
//                        }
//                    })
                }
            }


//            characters_body?.results?.let {
//                runOnUiThread {
//                    binding.recyclerView.adapter = CharacterAdapter(it, object : CharacterClickListener {
//                        override fun onCharacterClicker(character: Character) {
//                            Toast.makeText(this@MainActivity, character.textTitle, Toast.LENGTH_SHORT).show()
//                        }
//                    })
//                }
//            }
        }

    }
}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}