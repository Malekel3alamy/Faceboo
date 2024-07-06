package com.example.faceboo.data

import com.example.faceboo.pojo.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

   class PostClient {
       private val BASE_URL = "https://jsonplaceholder.typicode.com/"
       lateinit var  postClient: PostClient

    
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

       var  postInterface: PostInterface = retrofit.create(PostInterface::class.java)



    fun getPosts(): Call<List<PostModel>>{
        return postInterface.getPosts()
    }



   /* fun putPosts(): Call<PostModel>{
        return postInterface.putPosts()
    }*/



    fun getPostClientInstance() : PostClient{

        if(postClient == null){
            postClient = PostClient()
        }
        return postClient
    }
}



