package com.example.myjubjib

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AppointmentHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_history)

        // รับค่าจาก Intent
        val professor = intent.getStringExtra("professor")
        val date = intent.getStringExtra("date")
        val purpose = intent.getStringExtra("purpose")
        val time = intent.getStringExtra("time")

        // ใส่ค่าที่รับมาใน TextView
        findViewById<TextView>(R.id.appointmentDate1).text = "วันนัดหมาย: $date"
        findViewById<TextView>(R.id.appointmentDetails1).text = "จุดประสงค์: $purpose"
        findViewById<TextView>(R.id.appointmentTime1).text = "เวลานัดหมาย: $time"
        findViewById<TextView>(R.id.appointmentStatus1).text = "อาจารย์ที่จอง: $professor"
    }
}
