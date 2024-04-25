package ru.appsmile.rickandmorty

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
    @SerializedName(value = "name", alternate = ["user_name", "username", "Name"])
    val name: String,
    @SerializedName(value = "age")
    val userAge: Int,
    @SerializedName("phone_number")
    val phoneNumber: String,
    val isDead: Boolean,
    val capital: List<String> = emptyList()
) : Serializable