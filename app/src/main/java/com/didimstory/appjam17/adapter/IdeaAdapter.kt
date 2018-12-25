package com.didimstory.appjam17.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.didimstory.appjam17.R
import com.didimstory.appjam17.R.id.parent
import com.didimstory.appjam17.data.IdeaItem
import com.mikhaellopez.circularimageview.CircularImageView

class IdeaAdapter(items : ArrayList<IdeaItem>) : RecyclerView.Adapter<IdeaAdapter.ViewHolder>() {
    var items : ArrayList<IdeaItem>? = items

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): IdeaAdapter.ViewHolder {
        var view = LayoutInflater.from(p0.context)
                .inflate(R.layout.idae_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return items!!.size
    }

    override fun onBindViewHolder(p0: IdeaAdapter.ViewHolder, p1: Int) {
        var data :IdeaItem = items!![p1]
        p0.name.text = data.name
        p0.title.text = data.title
        p0.content.text = data.content
        Glide.with(p0.itemView.context).load(data.img).into(p0.profile)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name = itemView.findViewById(R.id.idaeName) as TextView
        var title = itemView.findViewById(R.id.idaeTitle) as TextView
        var content = itemView.findViewById(R.id.idaeContent) as TextView
        var profile = itemView.findViewById(R.id.signUpProfile) as CircularImageView
    }
}