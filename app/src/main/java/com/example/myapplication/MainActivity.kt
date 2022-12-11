package com.example.myapplication

import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calendarView = findViewById<CalendarView>(R.id.calendarView)

        val format = mutableListOf<SimpleDateFormat>(SimpleDateFormat("yyyy"), SimpleDateFormat("MM"), SimpleDateFormat("dd"))
        var today = mutableListOf<Int>(format[0].format(Date()).toInt(),format[1].format(Date()).toInt() -1,format[2].format(Date()).toInt());

        calendarView.setMinDate(Date().time)
        calendarView.setMaxDate(Date().time + 63115200000)
    }
}