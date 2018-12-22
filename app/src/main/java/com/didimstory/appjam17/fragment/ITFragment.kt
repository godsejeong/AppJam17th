package com.didimstory.appjam17.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didimstory.appjam17.R
import com.didimstory.appjam17.adapter.IdeaPagerAdapter
import android.support.v7.widget.LinearLayoutManager
//import com.didimstory.appjam17.adapter.IdeaAdapter
import com.didimstory.appjam17.data.IdeaItem
import kotlinx.android.synthetic.main.fragment_it.*


class ITFragment : Fragment() {
//    lateinit var adapter : IdeaAdapter
    lateinit var item : ArrayList<IdeaItem>
    companion object {

        @JvmStatic
        fun newInstance() = ITFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_it, container, false)

        val mLayoutManager = LinearLayoutManager(context!!.applicationContext)
        ideaRecyclerview.layoutManager = mLayoutManager

//        adapter = IdeaAdapter(item,user.getName())
//        ideaRecyclerview.setAdapter(adapter)

    }


}
