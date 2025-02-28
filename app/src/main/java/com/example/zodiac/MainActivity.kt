package com.example.zodiac

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val horoscopeList = listOf(
        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "taurus",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "gemini",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "cancer",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "leo",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),
//        Horoscope(id = "aries",R.drawable.aries_icon,R.string.horoscope_name_aries,R.string.horoscope_date_aries),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}