package com.example.zodiac

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    lateinit var iconImageView: ImageView
    lateinit var nameTextView: TextView
    lateinit var dateTextView: TextView
    lateinit var contentTextView: TextView
    lateinit var horoscope: Horoscope

    // variables para Menu item Favorito y manejarlo
    var isFavorite = false // si es favorito o no
    lateinit var favoriteMenu: MenuItem // identificar y hacer algo cuando le demos click al favorito <3

    //creamos variable para la session
    lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // creamos aqui la session para que se evalue todoo antes de iniciar el activity
        session = SessionManager(this)

        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!


        horoscope = Horoscope.findById(id)

        initView()
        loadData()

    }


    // creamos un menu en este Activity
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_detail, menu)
        //
        favoriteMenu = menu.findItem(R.id.action_favorite)
        //aqui ponemos el icono si el signo es favorito
        setFavoriteIcon()
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorite -> {
                isFavorite = !isFavorite
                if (isFavorite) {
                    session.setFavorite(horoscope.id)
                } else {
                    session.setFavorite("")
                }
                setFavoriteIcon()
                true
            }

            R.id.action_share -> {
                val sendIntent = Intent()
                sendIntent.setAction(Intent.ACTION_SEND)
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                sendIntent.setType("text/plain")

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
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

        isFavorite = session.isFavorite(horoscope.id)
    }

    private fun initView() {
        iconImageView = findViewById(R.id.iconImageView)
        nameTextView = findViewById(R.id.nombreSigno)
        dateTextView = findViewById(R.id.fechaSigno)
        contentTextView = findViewById(R.id.contenidoSigno)
    }

    private fun setFavoriteIcon() {
        if (isFavorite) {
            favoriteMenu.setIcon(R.drawable.ic_favorite_selected2)
        } else {
            favoriteMenu.setIcon(R.drawable.ic_favorite)
        }
    }
}