package com.didimstory.appjam17

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.didimstory.appjam17.data.User
import com.didimstory.appjam17.data.login
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {

    private val FINSH_INTERVAL_TIME = 2000
    private var backPressedTime:Long = 0

    private lateinit var Id:EditText
    private lateinit var Passwrod:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListeners()

    }

    private fun setListeners() {
        registerButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java));
        }

        loginButton.setOnClickListener {
            var user = login(loginID.text.toString(), loginPassword.text.toString())

        }

    }

    override fun onBackPressed() {
        val tempTime = System.currentTimeMillis()
        val intervalTime = tempTime - backPressedTime
        if (intervalTime in 0..FINSH_INTERVAL_TIME) {
            ActivityCompat.finishAffinity(this)
        } else {
            backPressedTime = tempTime
            Toast.makeText(applicationContext, "한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show()
        }
    }


}
