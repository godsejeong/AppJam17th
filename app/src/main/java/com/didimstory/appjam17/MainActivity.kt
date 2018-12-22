package com.didimstory.appjam17

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.didimstory.appjam17.Fragment.ITFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fragment : Fragment
    lateinit var fragmentManager: FragmentManager

    private val FINSH_INTERVAL_TIME = 2000
    private var backPressedTime:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        fragment = ITFragment.newInstance()
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment).commit()

    }

    val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.actionIT -> {

            }
            R.id.actionSprots -> {

            }

            R.id.actionEducation -> {

            }
            R.id.actionSell -> {

            }

            R.id.actionShowpping -> {

            }

            R.id.actionCook -> {

            }

            R.id.actionLend -> {

            }

            R.id.actionAuther-> {

            }
        }
        val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.content,fragment).commit()
        true
    }

    override fun onBackPressed() {
        var tempTime = System.currentTimeMillis()
        var intervalTime = tempTime - backPressedTime
        if (intervalTime in 0..FINSH_INTERVAL_TIME) {
            ActivityCompat.finishAffinity(this)
        } else {
            backPressedTime = tempTime
            Toast.makeText(applicationContext, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
    }
}
