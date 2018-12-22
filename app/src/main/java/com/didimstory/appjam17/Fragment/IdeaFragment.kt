package com.didimstory.appjam17.Fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.didimstory.appjam17.R
import com.didimstory.appjam17.R.id.parent
import com.didimstory.appjam17.adapter.IdeaPagerAdapter
import kotlinx.android.synthetic.main.fragment_idea.*
import kotlinx.android.synthetic.main.fragment_idea.view.*
import android.support.v7.app.AppCompatActivity




class IdeaFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = IdeaFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_idea, container, false)

        (activity as AppCompatActivity).supportActionBar!!.hide()

        view.ideaTab.addTab(view.ideaTab.newTab().setText("IT"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("스포츠"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("교육"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("유통 및 판매"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("쇼핑"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("외식 및 요리"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("대여 및 배달"))
        view.ideaTab.addTab(view.ideaTab.newTab().setText("기타"))

        view.ideaTab.tabGravity = TabLayout.GRAVITY_FILL

        val pageradapter = IdeaPagerAdapter(childFragmentManager,view.ideaTab.tabCount)

        view.ldeaViewpager.adapter = pageradapter

        view.ldeaViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(view.ideaTab))

        view.ideaTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view.ldeaViewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        return view
    }
}