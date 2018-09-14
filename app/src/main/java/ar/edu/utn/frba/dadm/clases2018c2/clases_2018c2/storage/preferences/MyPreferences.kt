package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.storage.preferences

import android.content.Context
import android.content.SharedPreferences

object MyPreferences {
    private const val preference_username = "preference_username"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences", Context.MODE_PRIVATE)
    }

    private fun getPreferencesEditor(context: Context): SharedPreferences.Editor {
        return getPreferences(context).edit()
    }

    fun setUsername(context: Context, username: String) {
        val editor = getPreferencesEditor(context)

        editor.putString(preference_username, username)

        editor.apply()
    }

    fun getUsername(context: Context) : String {
        val sharedPref = getPreferences(context)

        return sharedPref.getString(preference_username, "")
    }
}