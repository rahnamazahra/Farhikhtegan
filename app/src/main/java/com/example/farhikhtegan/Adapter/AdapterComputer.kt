package com.example.farhikhtegan.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.farhikhtegan.R
import com.example.farhikhtegan.model.ComputerListModel
import java.util.*
import kotlin.collections.ArrayList


class AdapterComputer(val context: Context, private val listModel:List<ComputerListModel>): RecyclerView.Adapter<AdapterComputer.Holder>() {
    lateinit var computerFilter:List<ComputerListModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_course,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.holderBinding(listModel[position],context)
    }

    override fun getItemCount(): Int {
        return listModel.count()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView =itemView.findViewById(R.id.img_course)
        var name: TextView =itemView.findViewById(R.id.title_course)

        @SuppressLint("SetTextI18n")
        fun holderBinding(item:ComputerListModel, context: Context){

           name.text=item.name
            val resourceId=context.resources.getIdentifier(item.img,"drawable",context.packageName)
            image.setImageResource(resourceId)

        }
    }

    }

