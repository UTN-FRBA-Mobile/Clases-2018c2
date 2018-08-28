package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class LoginFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener({ onLogin() })

        return view
    }

    fun onLogin() {
        val userName = activity!!.findViewById<EditText>(R.id.username)
        val password = activity!!.findViewById<EditText>(R.id.password)

        listener?.onLogin(userName.text.toString(), password.text.toString())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onLogin(userName: String, password: String)
    }
}
