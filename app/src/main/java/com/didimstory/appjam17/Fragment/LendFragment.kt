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


class LendFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = LendFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_lend, container, false)


        return view
    }
}
