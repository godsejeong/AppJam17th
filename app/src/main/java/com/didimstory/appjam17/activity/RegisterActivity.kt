package com.didimstory.appjam17.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.Toast
import com.didimstory.appjam17.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        registerButton.setOnClickListener {

            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            Toast.makeText(this@RegisterActivity, "회원가입 성공", Toast.LENGTH_LONG).show()

        }

        image1.setOnClickListener {
            image1.setImageResource(R.drawable.terms)
            image2.setImageResource(R.drawable.terms)
            image3.setImageResource(R.drawable.terms)
            image4.setImageResource(R.drawable.terms)
            image5.setImageResource(R.drawable.terms)
        }
        image2.setOnClickListener {
            image2.setImageResource(R.drawable.terms)
        }
        image3.setOnClickListener {
            image3.setImageResource(R.drawable.terms)
        }
        image4.setOnClickListener {
            image4.setImageResource(R.drawable.terms)
        }
        image5.setOnClickListener {
            image5.setImageResource(R.drawable.terms)
        }

    }

}
