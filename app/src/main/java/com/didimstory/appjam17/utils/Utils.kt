package com.didimstory.appjam17.utils

import android.content.Context
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

object Utils {

    var retrofit = Retrofit.Builder()
            .baseUrl("http://18.222.180.31:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    var postService = retrofit!!.create(Services::class.java)


    val MULTIPART_FORM_DATA = "multipart/form-data"

    fun createRequestBody(file: File, name: String): MultipartBody.Part {
        val mFile = RequestBody.create(MediaType.parse("images/*"), file)
        return MultipartBody.Part.createFormData(name, file.name, mFile)
    }
}