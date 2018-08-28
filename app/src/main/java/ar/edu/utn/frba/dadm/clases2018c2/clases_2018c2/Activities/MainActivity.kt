package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Fragments.DashboardFragment
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = intent.getStringExtra(PARAMETER_USERNAME)

        val dashboardFragment = DashboardFragment.newInstance(userName)

        supportFragmentManager.beginTransaction().add(R.id.fragment_container, dashboardFragment).commit()
    }

    companion object {
        const val PARAMETER_USERNAME = "USERNAME"
    }
}
