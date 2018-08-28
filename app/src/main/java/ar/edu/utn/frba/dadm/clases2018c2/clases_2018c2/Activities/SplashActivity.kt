package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Fragments.LoginFragment
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Fragments.SplashFragment


class SplashActivity : AppCompatActivity(), LoginFragment.OnFragmentInteractionListener {
    override fun onLogin(userName: String, password: String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.PARAMETER_USERNAME, userName)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashFragment = SplashFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, splashFragment).commit()

        val background = object : Thread() {
            override fun run() {
                Thread.sleep((2 * 1000).toLong())

                val loginFragment = LoginFragment()

                supportFragmentManager.beginTransaction().remove(splashFragment).add(R.id.fragment_container, loginFragment).commit()
            }
        }
        background.start()
    }
}
