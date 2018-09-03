package ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.Login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import ar.edu.utn.frba.dadm.clases2018c2.clases_2018c2.R

class SignUpStepTwoFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up_step_two, container, false)

        val signUpButton = view.findViewById<Button>(R.id.signUp_button)
        signUpButton.setOnClickListener {
            listener!!.onFinishSignUp()
        }

        viewModel = ViewModelProviders.of(activity!!).get(SignUpViewModel::class.java!!)

        view.findViewById<EditText>(R.id.userName).setText(viewModel.userName)
        view.findViewById<EditText>(R.id.password).setText(viewModel.password)

        return view
    }

    override fun onPause() {
        viewModel.userName = view?.findViewById<EditText>(R.id.userName)?.text.toString()
        viewModel.password = view?.findViewById<EditText>(R.id.password)?.text.toString()

        super.onPause()
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
        fun onFinishSignUp()
    }
}