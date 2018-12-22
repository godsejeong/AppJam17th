package com.didimstory.appjam17.Fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.didimstory.appjam17.R
import com.didimstory.appjam17.adapter.IdeaPagerAdapter
import kotlinx.android.synthetic.main.fragment_lend.view.*
import kotlinx.android.synthetic.main.fragment_project.view.*


/**
 * A simple [Fragment] subclass.
 */
class ProjectFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ProjectFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_project, container, false)

        (activity as AppCompatActivity).supportActionBar!!.hide()

        view.projectTab.addTab(view.projectTab.newTab().setText("IT"))
        view.projectTab.addTab(view.projectTab.newTab().setText("스포츠"))
        view.projectTab.addTab(view.projectTab.newTab().setText("교육"))
        view.projectTab.addTab(view.projectTab.newTab().setText("유통 및 판매"))
        view.projectTab.addTab(view.projectTab.newTab().setText("쇼핑"))
        view.projectTab.addTab(view.projectTab.newTab().setText("외식 및 요리"))
        view.projectTab.addTab(view.projectTab.newTab().setText("대여 및 배달"))
        view.projectTab.addTab(view.projectTab.newTab().setText("기타"))



        view.projectTab.tabGravity = TabLayout.GRAVITY_FILL

        val pageradapter = IdeaPagerAdapter(childFragmentManager,view.projectTab.tabCount)

        view.projectViewpager.adapter = pageradapter

        view.projectViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(view.projectTab))

        view.projectTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view.projectViewpager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        return view
    }

}// Required empty public constructor
