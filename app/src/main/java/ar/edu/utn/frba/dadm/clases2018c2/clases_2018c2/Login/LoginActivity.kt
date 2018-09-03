package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Dashboard.DashboardActivity
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class LoginActivity : AppCompatActivity(), LoginFragment.OnFragmentInteractionListener, SignUpStepOneFragment.OnFragmentInteractionListener, SignUpStepTwoFragment.OnFragmentInteractionListener {
    override fun onSignUp() {
        signUpStepOneFragment = SignUpStepOneFragment()

        supportFragmentManager.beginTransaction().remove(loginFragment).add(R.id.fragment_container, signUpStepOneFragment).addToBackStack(null).commit()
    }

    override fun onSignUpNextStep() {
        signUpStepTwoFragment = SignUpStepTwoFragment()

        supportFragmentManager.beginTransaction().remove(signUpStepOneFragment).add(R.id.fragment_container, signUpStepTwoFragment).addToBackStack(null).commit()
    }

    override fun onFinishSignUp() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onLogin(username: String, password: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private lateinit var loginFragment: LoginFragment
    private lateinit var signUpStepOneFragment: SignUpStepOneFragment
    private lateinit var signUpStepTwoFragment: SignUpStepTwoFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginFragment = LoginFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, loginFragment).commit()
    }
}