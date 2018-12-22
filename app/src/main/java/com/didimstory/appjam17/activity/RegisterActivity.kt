package com.didimstory.appjam17.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.didimstory.appjam17.R
import com.didimstory.appjam17.data.user
import com.didimstory.appjam17.utils.Utils
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        registerButton.setOnClickListener {



            if (editText1.text.toString().isNotEmpty() && editText2.text.toString().isNotEmpty() && editText3.text.toString().isNotEmpty() && editText4.text.toString().isNotEmpty() && editText5.text.toString().isNotEmpty() && editText6.text.toString().isNotEmpty()){


                if (editText4.text.toString() == editText5.text.toString()){
                val user = user(editText1.text.toString(), editText2.text.toString(), editText3.text.toString()
                , editText4.text.toString(), editText5.text.toString(), editText6.text.toString()
                )}else{
                    Toast.makeText(this@RegisterActivity, "비밀번호가 같지 않습니다.", Toast.LENGTH_SHORT).show()
                }

            }

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
