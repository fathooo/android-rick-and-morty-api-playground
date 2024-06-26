package com.fathooo.myapp.controller
import com.fathooo.myapp.BuildConfig
import com.fathooo.myapp.services.CharactersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterClient {
    val BASE_URL = BuildConfig.BASE_URL
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    val service = retrofit.create(CharactersService::class.java)
}