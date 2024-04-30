package ru.appsmile

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.appsmile.rickandmorty.Post
import ru.appsmile.rickandmorty.PostApiService

object RetrofitApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val rickAndMortyApiService = retrofit.create(PostApiService::class.java)

    fun getAllPost(): Call<List<Post>> = rickAndMortyApiService.getAllPost()
}


