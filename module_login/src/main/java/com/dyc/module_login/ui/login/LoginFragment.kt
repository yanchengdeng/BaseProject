package com.dyc.module_login.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ColorUtils
import com.blankj.utilcode.util.ToastUtils
import com.dyc.common.constants.ArouterPath
import com.dyc.common.view.afterTextChanged
import com.dyc.module_login.R
import com.dyc.module_login.databinding.LoginFragmentBinding
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.main_fragment.*

class LoginFragment : Fragment(R.layout.login_fragment) {

    private var loginFragmentBinding : LoginFragmentBinding? = null


    private lateinit var viewModel: LoginViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = LoginFragmentBinding.bind(view)
        loginFragmentBinding = binding

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)


        loginFragmentBinding?.username?.afterTextChanged {
            viewModel.setUserInfo(username = it)
        }

        loginFragmentBinding?.password?.afterTextChanged {
            viewModel.setUserInfo(password = it)
        }

        viewModel.loginSate.observe(viewLifecycleOwner,
            Observer {loginState ->
                when(loginState){
                    LoginStated.COMPLETE_SUCCESS ->{
                        loginFragmentBinding?.button?.setBackgroundColor(ColorUtils.getColor(R.color.colorAccent))
                        loginFragmentBinding?.button?.isEnabled = true
                    }

                    LoginStated.USER_NAME_EMPTY -> {
                        loginFragmentBinding?.button?.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        loginFragmentBinding?.button?.isEnabled = false
                        loginFragmentBinding?.username?.error = "请输入用户米"
                    }

                    LoginStated.PASSWORD_EMPTY -> {
                        loginFragmentBinding?.button?.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        loginFragmentBinding?.password?.error = "请输入密码"
                        loginFragmentBinding?.button?.isEnabled = false
                    }

                    LoginStated.ALL_EMPTY ->{
                        loginFragmentBinding?.button?.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        loginFragmentBinding?.button?.isEnabled = false
                    }
                }
            })



        loginFragmentBinding?.button?.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name",viewModel.getUserName())
            bundle.putString("password",viewModel.getPassword())
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment,bundle)
//            ARouter.getInstance().build(ArouterPath.PATH_REGISTER)
//                .withString("name",viewModel.getUserName())
//                .withString("password",viewModel.getPassword())
//                .navigation()


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginFragmentBinding = null
    }

}
