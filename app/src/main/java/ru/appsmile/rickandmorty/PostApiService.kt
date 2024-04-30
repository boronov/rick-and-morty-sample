package ru.appsmile.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface PostApiService {
    @GET("posts")
    fun getAllPost(): Call<List<Post>>
}