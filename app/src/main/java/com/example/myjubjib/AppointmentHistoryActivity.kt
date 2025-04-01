package com.example.myjubjib

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myjubjib.databinding.ActivityAppointmentHistoryBinding

class AppointmentHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // รับข้อมูลจาก Intent
        val professor = intent.getStringExtra("professor")
        val date = intent.getStringExtra("date")
        val purpose = intent.getStringExtra("purpose")
        val time = intent.getStringExtra("time")

        // แสดงข้อมูลใน RecyclerView
        if (professor != null && date != null && purpose != null && time != null) {
            val appointment = Appointment(date, professor, time, purpose)
            val appointments = listOf(appointment)

            val appointmentAdapter = AppointmentAdapter(appointments)
            binding.recyclerViewAppointments.layoutManager = LinearLayoutManager(this)
            binding.recyclerViewAppointments.adapter = appointmentAdapter
        }
    }
}
