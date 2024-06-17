package com.fathooo.myapp.services
import com.fathooo.myapp.model.Characters
import retrofit2.Call
import retrofit2.http.GET


interface CharactersService {
    @GET("api/character")
    fun listCharacters(): Call<Characters>
}