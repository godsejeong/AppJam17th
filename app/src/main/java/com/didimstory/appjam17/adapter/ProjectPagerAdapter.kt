package com.didimstory.appjam17.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.didimstory.appjam17.fragment.ITFragment
import com.didimstory.appjam17.fragment.LendFragment

class ProjectPagerAdapter(fm: FragmentManager?, tabCount : Int) : FragmentStatePagerAdapter(fm) {
    private var tabCount: Int = 8
    override fun getItem(p0: Int): Fragment? {

        return when (p0) {
            0 -> LendFragment(1)

            1 -> LendFragment(2)

            2 -> LendFragment(3)

            3 -> LendFragment(4)

            4 -> LendFragment(5)

            5 -> LendFragment(6)

            6 -> LendFragment(7)

            7 -> LendFragment(8)

            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}