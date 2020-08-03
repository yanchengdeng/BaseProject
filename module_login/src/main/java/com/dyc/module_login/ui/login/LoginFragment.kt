package com.dyc.module_login.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.dyc.module_login.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)



        button.setOnClickListener {
            if (viewModel.checkAccount(username.editableText.toString(),password.editableText.toString())) {
                var bundle = Bundle()
                bundle.putString("name",username.editableText.toString())
                bundle.putString("password",password.editableText.toString())
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment,bundle)
            }

        }
    }

}
