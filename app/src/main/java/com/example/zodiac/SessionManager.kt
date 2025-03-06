package com.example.zodiac

import android.content.Context

class SessionManager (context: Context) {
    //creamos variable para acceder a los metodos de preferencias para compartir
    private val sharedPref = context.getSharedPreferences("zodiac_session", Context.MODE_PRIVATE)

    // recibimos el nombre del signo
    fun setFavorite(id: String) {
        // asignamos clave-valor para el signo favorito
        val editor = sharedPref.edit()
        editor.putString("FAVORITE_HOROSCOPE", id)
        // guardamos los cambios : OBLIGATORIO O SINO NO SE GUARDAN
        editor.apply()
    }
    // retornamos el signo favorito y le damos un valor por defecto en caso de que no exista
    fun getFavorite(): String {
        return sharedPref.getString("FAVORITE_HOROSCOPE", "")!!
    }
    //aqui validaremos si es favorito o no y retornaremos un booleano
    fun isFavorite(id: String): Boolean {
        // hacemos in IF si el id recibido es igual al signo guardado en getFavorite
        return id == getFavorite()
    }
}
