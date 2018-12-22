package com.didimstory.appjam17.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.didimstory.appjam17.R
import com.didimstory.appjam17.data.User
import com.didimstory.appjam17.utils.ORMUtils
import com.didimstory.appjam17.utils.Utils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences



class LoginActivity : AppCompatActivity() {

    private val FINSH_INTERVAL_TIME = 2000
    private var backPressedTime: Long = 0

    private lateinit var Id: EditText
    private lateinit var Passwrod: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        registerButton.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        loginButton.setOnClickListener {
            if (loginID.text.toString().isNotEmpty() && loginPassword.text.toString().isNotEmpty()) {
                Login()
            } else {
                Toast.makeText(applicationContext, "아이디나 비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun Login() {
        var res: Call<User> = Utils.postService.login(loginID.text.toString(), loginPassword.text.toString())
        res.enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code() == 200) {
                    Log.e("login", Gson().toJson(response.body()))
                    ORMUtils(this@LoginActivity).userORM.save(response.body()!!.User)

                    val pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
                    val editor = pref.edit()
                    editor.putString("token",response.body()!!.User.token)
                    editor.commit()


                    출처@ http@ //arabiannight.tistory.com/entry/안드로이드Android-SharedPreferences-사용-예제 [아라비안나이트]

                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                    Toast.makeText(applicationContext, "로그인이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                } else if (response.code() == 404) {
                    Toast.makeText(applicationContext, "아이디나 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("code : ", response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "서버에서 에러가 발생하였습니다.", Toast.LENGTH_SHORT).show()
                Log.e("loginError", t.message)
            }
        })
    }

}
