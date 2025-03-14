package com.example.zodiac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)


    val ZodiacButton = findViewById<Button>(R.id.ZodiacButton)
        ZodiacButton.setOnClickListener {navigateZodiacView()}

    }

    private fun navigateZodiacView() {
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}