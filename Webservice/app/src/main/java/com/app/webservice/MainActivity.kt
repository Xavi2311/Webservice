package com.app.webservice

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.app.webservice.User


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


        val api = retrofit.create(userAPI::class.java); //Part 2


        val call = api.getUser()

        call.enqueue(object : Callback<User> {
                override fun onResponse(call: retrofit2.Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    Log.d("Funciona", userList.toString())
                } else {
                    Log.d("b", "otro error")
                }
            }


            override fun onFailure(call: retrofit2.Call<User>, t: Throwable) {
                t.message?.let { Log.d("error", it) }

            }
        })











             //Part Extra
        }

    }


