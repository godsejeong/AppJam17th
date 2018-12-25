package com.didimstory.appjam17.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.didimstory.appjam17.Fragment.IdeaFragment
import com.didimstory.appjam17.Fragment.ProjectFragment
import com.didimstory.appjam17.R
import com.didimstory.appjam17.adapter.IdeaPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.LinearLayoutManager



class MainActivity : AppCompatActivity() {
    lateinit var fragment : Fragment
    lateinit var fragmentManager: FragmentManager

    private val FINSH_INTERVAL_TIME = 2000
    private var backPressedTime:Long = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        fragment = IdeaFragment.newInstance()

        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainLayout,fragment).commit()
        mainIdea.setTextColor(this.resources.getColor(R.color.colorPrimary))

        mainAddBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
        }

        mainIdea.setOnClickListener {
            fragment = IdeaFragment.newInstance()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.mainLayout,fragment).commit()
            mainIdea.setTextColor(this.resources.getColor(R.color.colorPrimary))
            mainProject.setTextColor(this.resources.getColor(R.color.colorblack))
        }

        mainProject.setOnClickListener {
            fragment = ProjectFragment.newInstance()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.mainLayout,fragment).commit()
            mainIdea.setTextColor(this.resources.getColor(R.color.colorblack))
            mainProject.setTextColor(this.resources.getColor(R.color.colorPrimary))
        }
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