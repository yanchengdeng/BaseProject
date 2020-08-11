package com.dyc.module_login.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.blankj.utilcode.util.ColorUtils
import com.dyc.common.util.SysLog
import com.dyc.common.view.afterTextChanged
import com.dyc.module_login.R
import com.dyc.module_login.databinding.LoginFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment(R.layout.login_fragment) {

    private var loginFragmentBinding : LoginFragmentBinding? = null


    private val binding get() = loginFragmentBinding!!
    private val   viewModel : LoginViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginFragmentBinding = LoginFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.username.afterTextChanged {
            viewModel.setUserInfo(username = it)
        }

        binding.password.afterTextChanged {
            viewModel.setUserInfo(password = it)
        }

        viewModel.loginSate.observe(viewLifecycleOwner,
            Observer {loginState ->
                when(loginState){
                    LoginStated.COMPLETE_SUCCESS ->{
                        binding.button.setBackgroundColor(ColorUtils.getColor(R.color.colorAccent))
                        binding.button.isEnabled = true
                    }

                    LoginStated.USER_NAME_EMPTY -> {
                        binding.button.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        binding.button.isEnabled = false
                        binding.username.error = "请输入用户米"
                    }

                    LoginStated.PASSWORD_EMPTY -> {
                        binding.button.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        binding.password.error = "请输入密码"
                        binding.button.isEnabled = false
                    }

                    LoginStated.ALL_EMPTY ->{
                        binding.button.setBackgroundColor(ColorUtils.getColor(android.R.color.darker_gray))
                        binding.button.isEnabled = false
                    }
                }
            })


        viewModel.loginInfo.observe(viewLifecycleOwner, Observer {
            binding.loginData.text = "$it"
        })



        binding.button.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("name",viewModel.getUserName())
//            bundle.putString("password",viewModel.getPassword())
//            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment,bundle)


            viewModel.doLogin()

            //TODO  使用Arouter  做navigation 跳转失败，思考下 fragment 在navigate 下 直接使用Arouter 跳转
            //todo 或者类似 navigation 这样的控件 直接使用navigation导航传值就可以了
               /* ARouter.getInstance().build(ArouterPath.PATH_REGISTER)
                    .withString("name",viewModel.getUserName())
                    .withString("password",viewModel.getPassword())
                    .navigation(activity,object :NavigationCallback{
                        override fun onLost(postcard: Postcard?) {
                            SysLog.d(msg = postcard.toString())
                        }

                        override fun onFound(postcard: Postcard?) {
                            SysLog.d(msg = postcard.toString())
                        }

                        override fun onInterrupt(postcard: Postcard?) {
                            SysLog.d(msg = postcard.toString())
                        }

                        override fun onArrival(postcard: Postcard?) {
                            SysLog.d(msg = postcard.toString())
                        }
                    })*/
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginFragmentBinding = null
    }

}


