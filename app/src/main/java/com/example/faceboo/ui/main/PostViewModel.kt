package com.example.faceboo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.faceboo.data.PostClient
import com.example.faceboo.pojo.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
           var postMutableLiveDat = MutableLiveData<List<PostModel>>()
           private val postClient = PostClient()

    fun getPosts() : MutableLiveData<List<PostModel>>{

         val cllList = postClient.getPosts()
        cllList.enqueue(object : Callback<List<PostModel>>{
            override fun onFailure(p0: Call<List<PostModel>>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<List<PostModel>>, p1: Response<List<PostModel>>) {

                postMutableLiveDat.value = p1.body()
            }

        })

        return postMutableLiveDat


    }

}