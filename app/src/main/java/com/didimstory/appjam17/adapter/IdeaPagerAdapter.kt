package com.didimstory.appjam17.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.didimstory.appjam17.Fragment.*
import com.didimstory.appjam17.fragment.ITFragment
import com.didimstory.appjam17.fragment.LendFragment

class IdeaPagerAdapter(fm: FragmentManager?, tabCount : Int) : FragmentStatePagerAdapter(fm) {
    private var tabCount: Int = 8
    override fun getItem(p0: Int): Fragment? {

        return when (p0) {
            0 -> ITFragment(1)

            1 -> ITFragment(2)

            2 -> ITFragment(3)

            3 -> ITFragment(4)

            4 -> ITFragment(5)

            5 -> ITFragment(6)

            6 -> ITFragment(7)

            7 -> ITFragment(8)

            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}