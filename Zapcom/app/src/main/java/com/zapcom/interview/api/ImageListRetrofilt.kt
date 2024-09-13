package com.zapcom.interview.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ImageListRetrofilt {
    val api : ImageListApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.jsonkeeper.com/b/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageListApi::class.java)
    }
}
