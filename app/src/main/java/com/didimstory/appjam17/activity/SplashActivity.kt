package com.didimstory.appjam17.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.didimstory.appjam17.R
import com.didimstory.appjam17.data.User
import com.didimstory.appjam17.data.UserData
import com.didimstory.appjam17.utils.ORMUtils

class SplashActivity : AppCompatActivity() {
    var token : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        try {
            val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
            token = pref.getString("token",null)
        } catch (e: Exception) {
            token = null
        }


        val handler = Handler()
        handler.postDelayed({
            if(token != null){
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        },1000)

    }
}
