package com.fathooo.myapp.controller
import com.fathooo.myapp.services.CharactersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    val service = retrofit.create(CharactersService::class.java)
}