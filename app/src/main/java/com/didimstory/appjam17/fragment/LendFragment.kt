package com.didimstory.appjam17.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.didimstory.appjam17.R
import com.didimstory.appjam17.adapter.IdeaAdapter
import com.didimstory.appjam17.adapter.IdeaPagerAdapter
import com.didimstory.appjam17.adapter.ProjectAdapter
import com.didimstory.appjam17.data.AllList
import com.didimstory.appjam17.data.IdeaItem
import com.didimstory.appjam17.data.ProjectData
import com.didimstory.appjam17.utils.Utils
import kotlinx.android.synthetic.main.fragment_it.view.*
import kotlinx.android.synthetic.main.fragment_lend.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@SuppressLint("ValidFragment")
class LendFragment @SuppressLint("ValidFragment") constructor
(var number : Int) : Fragment() {
    lateinit var adapter : ProjectAdapter
    var item : ArrayList<ProjectData> = java.util.ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_lend, container, false)

        val mLayoutManager = GridLayoutManager(context!!.applicationContext,2)
        view.projectRecyclerivew.layoutManager = mLayoutManager

        adapter = ProjectAdapter(item)
        view.projectRecyclerivew.adapter = adapter

        var res: Call<AllList> = Utils.postService.projectList(number)

        res.enqueue(object : Callback<AllList>{
            override fun onFailure(call: Call<AllList>, t: Throwable) {
                Log.e("newIdeaError",t.message)
                Toast.makeText(context, "서버에서 에러가 발생하였습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<AllList>, response: Response<AllList>) {
                if(response.code() == 200){

                    (0 until response.body()!!.list.size).forEach {
                        item.add(ProjectData(response.body()!!.list[it].mainImg,
                                response.body()!!.list[it].title,
                                response.body()!!.list[it].company)
                        )
                    }
                    adapter.notifyDataSetChanged()
                }else{
                    Log.e("Errorcode :" , response.code().toString())
                }
            }

        })

        return view
    }
}
