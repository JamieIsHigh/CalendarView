package com.example.myapplication

import android.os.Bundle
import android.widget.Button
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
        val wyjazdButton = findViewById<Button>(R.id.wyjazdButton)
        val powrotButton = findViewById<Button>(R.id.powrotButton)
        val wyjazd = findViewById<TextView>(R.id.wyjazd)
        val powrot = findViewById<TextView>(R.id.powrot)
        val naglowek = findViewById<TextView>(R.id.naglowek)

        var isWyjazdSet = false
        var isPowrotSet = false
        var isWyjazdSetting = false
        var isPowrotSetting = false

        var dataWyjazdu = 1000000000
        var dataPowrotu = 1000000000


        val format = mutableListOf<SimpleDateFormat>(SimpleDateFormat("yyyy"), SimpleDateFormat("MM"), SimpleDateFormat("dd"))
        var today = mutableListOf<Int>(format[0].format(Date()).toInt(),format[1].format(Date()).toInt() -1,format[2].format(Date()).toInt());

        calendarView.setMinDate(Date().time)
        calendarView.setMaxDate(Date().time + 63115200000)

        wyjazdButton.setOnClickListener {
            if (!isWyjazdSetting) {
                naglowek.text = "Wybierz na kalendarzu datę wyjazdu: "
                wyjazdButton.text = "Anuluj"
                isWyjazdSetting = true
            } else {
                wyjazdButton.text = "Ustaw/zmień datę wyjazdu"
                isWyjazdSetting = false
            }
        }
    }
}