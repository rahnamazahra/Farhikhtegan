package com.example.farhikhtegan.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.farhikhtegan.R
import com.example.farhikhtegan.model.TeacherModel

class TeacherAdapter(val context: Context, private val list:List<TeacherModel>): RecyclerView.Adapter<TeacherAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_teacher,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       return holder.holderBinding(list[position],context)
    }

    override fun getItemCount(): Int {
       return list.count()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var image: ImageView =itemView.findViewById(R.id.img_teacher)
        private var fulltname: TextView =itemView.findViewById(R.id.full_name_teacher)

       @SuppressLint("SetTextI18n")
       fun holderBinding(teacher: TeacherModel, context:Context){

           fulltname.text=teacher.firstName+" "+teacher.lastName
           val resourceId=context.resources.getIdentifier(teacher.image,"drawable",context.packageName)
           image.setImageResource(resourceId)

       }
    }

}