package ru.appsmile

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.appsmile.rickandmorty.Item
import ru.appsmile.rickandmorty.RickAndMortyApiService

object RetrofitApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val rickAndMortyApiService = retrofit.create(RickAndMortyApiService::class.java)

    fun getCharacter(): Call<Item> = rickAndMortyApiService.getCharacter()
}


