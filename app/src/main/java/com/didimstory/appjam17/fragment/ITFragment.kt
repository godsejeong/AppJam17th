package com.didimstory.appjam17.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.didimstory.appjam17.R
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.didimstory.appjam17.adapter.IdeaAdapter
import com.didimstory.appjam17.data.AllList
//import com.didimstory.appjam17.adapter.IdeaAdapter
import com.didimstory.appjam17.data.IdeaItem
import com.didimstory.appjam17.utils.Utils
import kotlinx.android.synthetic.main.fragment_it.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@SuppressLint("ValidFragment")
class ITFragment @SuppressLint("ValidFragment") constructor
(var number : Int) : Fragment() {
    lateinit var adapter : IdeaAdapter
    var item : ArrayList<IdeaItem> = java.util.ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        item.clear()
        var res: Call<AllList> = Utils.postService.newIdea(number)
        res.enqueue(object : Callback<AllList>{
            override fun onFailure(call: Call<AllList>, t: Throwable) {
                Log.e("AllError",t.message)
                Toast.makeText(context, "서버에서 에러가 발생하였습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<AllList>, response: Response<AllList>) {
                if(response.code() == 200){

                    (0 until response.body()!!.list.size).forEach {
                        item.add(IdeaItem("http://18.222.180.31:3000/profile/profile.png",
                                response.body()!!.list[it].name,
                                response.body()!!.list[it].title,
                                response.body()!!.list[it].index)
                        )
                    }

                    adapter.notifyDataSetChanged()

                    Log.e("tjdrhd","성공")
                }else{
                    Log.e("Errorcode :" , response.code().toString())
                }
            }
        })
}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_it, container, false)

        val mLayoutManager = LinearLayoutManager(context!!.applicationContext)
        view.ideaRecyclerview.layoutManager = mLayoutManager

        adapter = IdeaAdapter(item!!)
        view.ideaRecyclerview.adapter = adapter


        return view
    }

}
