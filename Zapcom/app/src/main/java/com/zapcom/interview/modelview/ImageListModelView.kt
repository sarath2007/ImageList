package com.zapcom.interview.modelview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zapcom.interview.api.ImageListRetrofilt
import com.zapcom.interview.models.ImageListAPIResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageListModelView: ViewModel() {
    private var imageLiveData = MutableLiveData<ImageListAPIResponse>()
    fun getImageList() {
        ImageListRetrofilt.api.getImageList().enqueue(object  : Callback<ImageListAPIResponse> {
            override fun onResponse(call: Call<ImageListAPIResponse>, response: Response<ImageListAPIResponse>) {
                if (response.body()!=null){
                    imageLiveData.value = response.body()//!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<ImageListAPIResponse>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeImagesLiveData() : LiveData<ImageListAPIResponse> {
        return imageLiveData
    }
}