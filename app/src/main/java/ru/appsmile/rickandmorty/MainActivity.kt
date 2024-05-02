package ru.appsmile.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.appsmile.RetrofitApi
import ru.appsmile.rickandmorty.adapter.RickAndMortyAdapter
import ru.appsmile.rickandmorty.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* val user = User(
             name = "Anton",
             userAge = 10,
             phoneNumber = "+992900000001",
             isDead = true
         )


         val user2 = User(
             name = "Vlad",
             userAge = 30,
             phoneNumber = "+7900000001",
             isDead = false,
             capital = listOf("Машина", "Дом", "Водка")
         )


         val list = listOf(user, user2)

         Log.d("TAG_USER", "user: $user")

         val gson = Gson()

         val jsonUser = gson.toJson(user)


         Log.d("TAG_USER", "jsonUser: $jsonUser")

         val jsonString = """{"age":11,"isDead":false,"name":"Sergey","phone_number":"значение", "country":"Tajikistan"}"""

         val jsonString2 = """{"age":11,"isDead":false,"user_name":"Sergey","phone_number":"значение", "user_country":"Tajikistan"}"""

         val userNew = gson.fromJson(jsonString, User::class.java)


         Log.d("TAG_USER", "userNew: $userNew")

         val userNew2 = gson.fromJson(jsonString2, User::class.java)


         Log.d("TAG_USER", "userNew2: $userNew2")


         val userJsonString = gson.toJson(list)

         Log.d("TAG_USER", "userJsonString: $userJsonString")*/

        binding.root.layoutManager = LinearLayoutManager(this)


        RetrofitApi.getCharacter().enqueue(object : Callback<Item> {
            override fun onResponse(p0: Call<Item>, p1: Response<Item>) {

                if (p1.isSuccessful) {
                    val resultList = p1.body()?.results ?: emptyList()
                    binding.root.adapter =
                        RickAndMortyAdapter(resultList, listener = { item, name,  ->
                            Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT)
                                .show()
                        })
                    // все океей
                } else {

                    Log.d("TAG_TEST", "!isSuccessful: что то пошло не так")
                    // что то пошло не так
                }
            }

            override fun onFailure(p0: Call<Item>, p1: Throwable) {

                Log.d("TAG_TEST", "onFailure: вообще что то пошло не так ${p1.message}")
            }
        })
    }

}