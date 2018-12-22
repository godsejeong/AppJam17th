package com.didimstory.appjam17.utils

import com.didimstory.appjam17.data.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Services{

    @FormUrlEncoded
    @POST("/signin")
    fun login(@Field ("id") id : String,
              @Field("passwd")passwd : String) : Call<User>
}