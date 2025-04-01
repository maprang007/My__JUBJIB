package com.example.myjubjib

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_edit_author) // ใช้ layout ของ dialog_edit_author.xml

        // กำหนดข้อมูลชื่ออาจารย์ที่จะแสดงใน Spinner
        val professors = arrayOf("อาจารย์วิชัย สมบัติ", "อาจารย์บุญชู จิตนุพงศ์")

        // เชื่อมต่อ Spinner กับ ArrayAdapter
        val spinner = findViewById<Spinner>(R.id.spinnerTeacher)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, professors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // เชื่อมโยงกับ TextInputEditText สำหรับกรอกวันที่
        val editDate = findViewById<TextInputEditText>(R.id.editDate)

        // เพิ่ม TextWatcher เพื่อตรวจสอบการกรอกวันที่
        editDate.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                val text = charSequence.toString()
                // ตรวจสอบการกรอกวันที่
                if (text.length == 2 || text.length == 5) {
                    // เพิ่ม / หลังจาก 2 ตัวแรก และ 2 ตัวถัดไป
                    if (!text.contains("/")) {
                        editDate.setText("$text/")
                        editDate.setSelection(editDate.text?.length ?: 0) // เลื่อนไปที่ตำแหน่งสุดท้าย
                    }
                }
            }

            override fun afterTextChanged(editable: Editable?) {}
        })

        // กำหนดปุ่มตกลง
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // เปิดหน้า AppointmentHistoryActivity โดยไม่ต้องส่งข้อมูล
            val intent = Intent(this, AppointmentHistoryActivity::class.java)
            startActivity(intent) // เปิดหน้า AppointmentHistoryActivity
        }
    }
}
