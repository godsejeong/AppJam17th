package com.didimstory.appjam17

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_main -> {
//                        fragment = SeasonFragment.newInstance()
                }
                R.id.action_cody -> {
//                        fragment = CodyFragment.newInstance()
                }
                R.id.action_sale -> {
//                        fragment = SaleFragment.newInstance()
                }
                R.id.action_locker -> {
//                        fragment = LockerFragment.newInstance()
                }
            }
            val transaction = fragmentManager.beginTransaction()
//                transaction.replace(R.id.content, fragment).commit()
            true
        }
    }
}
