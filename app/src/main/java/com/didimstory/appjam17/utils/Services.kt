package com.didimstory.appjam17.utils

import com.didimstory.appjam17.data.AllList
import com.didimstory.appjam17.data.BasicData
import com.didimstory.appjam17.data.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Services {

    @FormUrlEncoded
    @POST("/signin")
    fun login(@Field("id") id: String,
              @Field("passwd") passwd: String): Call<User>

    @FormUrlEncoded
    @POST("/newIdea")
    fun newIdea(@Field("profileImg") profileImg: String,
                @Field("category") category: String,
                @Field("name") name: String,
                @Field("title") title: String,
                @Field("index") index: String,
                @Field("userToken") userToken: String)
            : Call<BasicData>

    @FormUrlEncoded
    @POST("/ideaList")
    fun newIdea(@Field("number") number: Int): Call<AllList>

    @FormUrlEncoded
    @POST("/projectList")
    fun projectList(@Field("number") number: Int): Call<AllList>
}