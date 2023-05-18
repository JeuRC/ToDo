package com.example.todo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private val taskList= mutableListOf<Task>()


class Tasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val imgIcon = findViewById<ImageView>(R.id.imgIcon)
        val btnProfile = findViewById<Button>(R.id.btnProfile)
        val imgPlus1 = findViewById<ImageButton>(R.id.imgPlus1)
        val imgLists = findViewById<ImageView>(R.id.imgLists)
        val txtLists = findViewById<TextView>(R.id.txtLists)
        val imgCalendar = findViewById<ImageView>(R.id.imgCalendar)
        val txtCalendar = findViewById<TextView>(R.id.txtCalendar)
        imgIcon.setOnClickListener{
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
        btnProfile.setOnClickListener{
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        imgPlus1.setOnClickListener{
            val intent = Intent(this, AddTasks::class.java)
            startActivity(intent)
        }
        imgLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        txtLists.setOnClickListener{
            val intent = Intent(this, Lists::class.java)
            startActivity(intent)
        }
        imgCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        txtCalendar.setOnClickListener{
            val intent = Intent(this, Calendar::class.java)
            startActivity(intent)
        }
        loadTasks()
        rvwTaskToday()

    }
    private fun rvwTaskToday(){
        val task = intent.getStringExtra("task")
        if (!task.isNullOrEmpty()) {
            val data = Task(task.toString())
            taskList.add(data)
        }
        saveTasks()
        val recyclerView = findViewById<RecyclerView>(R.id.rvwTaskToday)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(taskList)
    }
    private fun saveTasks() {
        val sharedPreferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(taskList)
        editor.putString("TASK_LIST", json)
        editor.apply()
    }
    private fun loadTasks() {
        val sharedPreferences = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("TASK_LIST", null)
        val type = object : TypeToken<MutableList<Task>>() {}.type
        taskList.clear()
        if(json != null) {
            taskList.addAll(gson.fromJson(json, type))
        }
    }
}