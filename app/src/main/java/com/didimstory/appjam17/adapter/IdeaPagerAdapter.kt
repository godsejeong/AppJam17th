package com.didimstory.appjam17.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.didimstory.appjam17.Fragment.*

class IdeaPagerAdapter(fm: FragmentManager?, tabCount : Int) : FragmentStatePagerAdapter(fm) {
    private var tabCount: Int = 8
    override fun getItem(p0: Int): Fragment? {

        return when (p0) {
            0 -> ITFragment.newInstance()

            1 -> ITFragment.newInstance()

            2 -> ITFragment.newInstance()

            3 -> ITFragment.newInstance()

            4 -> ITFragment.newInstance()

            5 -> ITFragment.newInstance()

            6 -> ITFragment.newInstance()

            7 -> ITFragment.newInstance()

            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}