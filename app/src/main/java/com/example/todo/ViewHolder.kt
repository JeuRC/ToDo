package com.example.todo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder (view: View):RecyclerView.ViewHolder(view){

    private val task = view.findViewById<TextView>(R.id.cbxTask)

    fun render(taskModel: Task){
       task.text = taskModel.task
    }
}


