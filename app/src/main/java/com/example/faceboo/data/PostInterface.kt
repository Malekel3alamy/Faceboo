package com.example.faceboo.data

import com.example.faceboo.pojo.PostModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PostInterface {

    @GET("posts")
  fun   getPosts() : Call<List<PostModel>>

  @POST("posts")
  fun putPosts(@Body postModel: PostModel) : Call<PostModel>

}