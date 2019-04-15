package com.example.mvvm_livedata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_livedata.R
import com.example.mvvm_livedata.model.dto.RepoDTO
import kotlinx.android.synthetic.main.recycleritem.view.*

class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var list = ArrayList<RepoDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycleritem,parent,false)

        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.itemTextView.text = list[position].name
    }

    class CustomViewHolder (view : View) : RecyclerView.ViewHolder(view)




}