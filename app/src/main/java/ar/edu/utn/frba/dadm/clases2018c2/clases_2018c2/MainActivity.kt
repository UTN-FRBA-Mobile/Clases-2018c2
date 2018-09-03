package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener, StatusUpdateFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            // Solo la primera vez que corre el activity
            // Las demás el propio manager restaura todo como estaba
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, MainFragment())
                    .commit()
        }
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }
}
