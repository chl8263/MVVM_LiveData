package com.example.mvvm_livedata.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_livedata.R
import com.example.mvvm_livedata.model.dto.RepoDTO

class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var list = ArrayList<RepoDTO>()
        set(value) {
            list = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CustomViewHolder (view : View) : RecyclerView.ViewHolder(view){
        val repoName : TextView by lazy {
            view.findViewById(R.id.)
        }


    }


}