package ru.appsmile.rickandmorty

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    fun getCharacter(): Call<Item>
}

data class Item(
    @SerializedName("results")
    val results: List<ResultItem>
)

data class ResultItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("origin")
    val origin: LocationItem,
    @SerializedName("location")
    val location: LocationItem
)

data class LocationItem(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)