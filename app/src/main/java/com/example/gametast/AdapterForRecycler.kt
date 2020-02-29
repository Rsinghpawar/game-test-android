package com.example.gametast

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_for_recycler.view.*

class AdapterForRecycler (val context : Context , val list : List<Int>) : RecyclerView.Adapter<AdapterForRecycler.ViewHolder>()
{

    var incomingNumber = 0
    var currentView : View? = null
    var currentPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_for_recycler , parent , false)
        currentView=view
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]
        holder.binder(item , position)
        if (position == 15) holder.itemView.txt_postion.setBackgroundColor(ContextCompat.getColor(context , R.color.startPosition))
        if (position == 0) holder.itemView.txt_postion.setBackgroundColor(ContextCompat.getColor(context , R.color.endPosition))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun binder(item : Int , postion : Int) {
            itemView.txt_postion.text = item.toString()

        }

    }
}