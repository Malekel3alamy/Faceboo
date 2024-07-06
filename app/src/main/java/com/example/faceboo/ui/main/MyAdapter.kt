package com.example.faceboo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.faceboo.pojo.PostModel

 class MyAdapter( ) :
     RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

     var postList : ArrayList<PostModel> = ArrayList()
    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
val itemView   = LayoutInflater.from(parent.context).
inflate(com.example.faceboo.R.layout.post_item,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = postList[position]

        holder.tv_title.text = post.title
        holder.tv_body.text = post.body
        holder.tv_userId.text = post.userId.toString()
    }

    class MyViewHolder(view : View): ViewHolder(view){

        val tv_title = view.findViewById<TextView>(com.example.faceboo.R.id.title_tv)
        val tv_body = view.findViewById<TextView>(com.example.faceboo.R.id.body_tv)
        val tv_userId = view.findViewById<TextView>(com.example.faceboo.R.id.user_id_tv)



    }
     fun setList(list: ArrayList<PostModel>)  {

        this.postList = list
         notifyDataSetChanged()
     }
}

