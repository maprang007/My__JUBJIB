package com.example.myjubjib

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // เชื่อมโยงกับ layout ของหน้าล็อกอิน

        // ตรวจสอบการเชื่อมต่อกับ EditText และ Button ที่มีใน layout
        val emailEditText = findViewById<EditText>(R.id.editTextTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.button4)

        // ตั้งค่า onClickListener สำหรับปุ่ม Login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString() // ค่าของ email
            val password = passwordEditText.text.toString() // ค่าของ password

            // ตรวจสอบว่าอีเมลและรหัสผ่านไม่ว่าง
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // หากกรอกทั้งสองช่อง
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                // เปิดหน้าใหม่ (DialogActivity)
                val intent = Intent(this, DialogActivity::class.java) // สร้าง Intent เพื่อเปิด DialogActivity
                startActivity(intent) // เรียกใช้ startActivity เพื่อเปิดหน้าต่างใหม่
            } else {
                // หากช่องใดช่องหนึ่งว่าง
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
