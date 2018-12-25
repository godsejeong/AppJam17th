package com.didimstory.appjam17.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.didimstory.appjam17.R
import com.didimstory.appjam17.R.id.parent
import com.didimstory.appjam17.data.IdeaItem
import com.didimstory.appjam17.data.ProjectData
import com.mikhaellopez.circularimageview.CircularImageView

class ProjectAdapter(items : ArrayList<ProjectData>) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {
    var items : ArrayList<ProjectData>? = items

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProjectAdapter.ViewHolder {
        var view = LayoutInflater.from(p0.context)
                .inflate(R.layout.project_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

    override fun onBindViewHolder(p0: ProjectAdapter.ViewHolder, p1: Int) {
        var data :ProjectData = items!![p1]
        p0.content.text = data.title
        p0.make.text = data.make

        Glide.with(p0.itemView.context).load(data.img).into(p0.image)

        Log.e("data.img",data.img)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var content = itemView.findViewById(R.id.projectcontent) as TextView
        var make = itemView.findViewById(R.id.make) as TextView
        var image = itemView.findViewById(R.id.projcetImg) as ImageView
    }
}