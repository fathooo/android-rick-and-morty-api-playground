package com.fathooo.myapp.services
import com.fathooo.myapp.model.Characters
import com.fathooo.myapp.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CharactersService {
    @GET("api/character")
    fun listCharacters(): Call<Characters>

    @GET("api/character/{id}")
    fun getCharacter(@Path("id") id: Int): Call<Character>
}