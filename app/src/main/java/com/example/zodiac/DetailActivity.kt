package com.example.zodiac

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"

    }
    lateinit var iconImageView:ImageView
    lateinit var nameTextView: TextView
    lateinit var dateTextView: TextView
    lateinit var contentTextView: TextView
    lateinit var horoscope: Horoscope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!


        horoscope = Horoscope.findById(id)

        initView()
        loadData()
}



// creamos un menu en este Activity
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_activity_detail, menu)
            return true
        }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.action_favorite -> {
                    println("Menu favorito")
                    true
                }
                R.id.action_share -> {
                    println("Menu compartir")
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }






    private fun loadData() {
    // creamos en la barra el nombre del signo y la fecha
        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.dates)
        //------------------------------------------
        iconImageView.setImageResource(horoscope.icon)
        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.dates)
    }

    private fun initView() {
        iconImageView = findViewById(R.id.iconImageView)
        nameTextView = findViewById(R.id.nombreSigno)
        dateTextView = findViewById(R.id.fechaSigno)
        contentTextView = findViewById(R.id.contenidoSigno)
    }
}