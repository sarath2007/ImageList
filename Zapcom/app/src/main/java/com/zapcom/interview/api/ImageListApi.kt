package com.zapcom.interview.api

import com.zapcom.interview.models.ImageListAPIResponse
import retrofit2.Call
import retrofit2.http.GET


interface ImageListApi {
    @GET("5BEJ")
    fun getImageList() : Call<ImageListAPIResponse>
}
