package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import android.provider.ContactsContract.Data
import android.view.View
import androidx.core.view.get
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

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

        var dataWyjazdu = 1000000000000
        var dataPowrotu = 1000000000000
        var dataWybrana = mutableListOf<Int>(0,0,0)

        var roznica: Long = 1000000000000
        var selectedD = 100000000000

        val format = mutableListOf<SimpleDateFormat>(SimpleDateFormat("yyyy"), SimpleDateFormat("MM"), SimpleDateFormat("dd"))
        var today = mutableListOf<Int>(format[0].format(Date()).toInt(),format[1].format(Date()).toInt() -1,format[2].format(Date()).toInt());
        var days = 1000000000000

        calendarView.setMinDate(Date().time)
        calendarView.setMaxDate(Date().time + 63115200000)

        fun liczenieDni() {
            if (isWyjazdSet && isPowrotSet) {
                naglowek.text = ""
                roznica = (dataPowrotu - dataWyjazdu).toLong()
                days = roznica/86400000
            } else if (!isWyjazdSet && isPowrotSet) {
                naglowek.text = "Ustaw date wyjazdu!"
            } else if (isWyjazdSet && !isPowrotSet) {
                naglowek.text = "Ustaw date powrotu!"
            } else if (!isWyjazdSet && !isPowrotSet) {
                naglowek.text = "Ustaw datę wyjazdu i powrotu!"
            }
        }

        wyjazdButton.setOnClickListener {
            if (!isWyjazdSetting) {
                naglowek.text = "Wybierz na kalendarzu datę wyjazdu: "
                wyjazdButton.text = "Anuluj"
                isWyjazdSetting = true
            } else {
                wyjazdButton.text = "Ustaw/zmień datę wyjazdu"
                isWyjazdSetting = false
                liczenieDni()
            }
        }
        powrotButton.setOnClickListener {
            if (!isPowrotSetting) {
                naglowek.text = "Wybierz na kalendarzu datę powrotu: "
                powrotButton.text = "Anuluj"
                isPowrotSetting = true
            } else {
                powrotButton.text = "Ustaw/zmień datę powrotu"
                isPowrotSetting = false
                liczenieDni()
            }
        }

        calendarView.setOnDateChangeListener { view, year, month, day ->/*
            dataWybrana[0] = year
            dataWybrana[1] = month
            dataWybrana[2] = day*/
            selectedD = calendarView.date
            naglowek.text = selectedD.toString()
            if (isWyjazdSetting) {
                dataWyjazdu = selectedD
                wyjazd.text = "Data wyjazdu: " + dataWyjazdu.toString()
                isWyjazdSetting = false
                wyjazdButton.text = "Ustaw/zmień datę wyjazdu"
                liczenieDni()
                isWyjazdSet = true
            } else if (isPowrotSetting) {
                dataPowrotu = selectedD
                powrot.text = "Data powrotu: " + dataPowrotu.toString()
                isPowrotSetting = false
                powrotButton.text = "Ustaw/zmień datę powrotu"
                liczenieDni()
                isPowrotSet = true
            }
        }
    }
}