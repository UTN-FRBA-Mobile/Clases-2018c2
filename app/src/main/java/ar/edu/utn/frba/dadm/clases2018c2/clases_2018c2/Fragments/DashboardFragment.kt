package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class DashboardFragment : Fragment() {
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(ARG_USERNAME)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val userNameTextView = view.findViewById<TextView>(R.id.username)
        userNameTextView.text = String.format(resources.getString(R.string.hi), userName)

        return view
    }

    companion object {
        const val ARG_USERNAME = "USER_NAME"

        @JvmStatic
        fun newInstance(userName: String) =
                DashboardFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_USERNAME, userName)
                    }
                }
    }
}
