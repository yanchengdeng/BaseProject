package com.dyc.module_login.ui.register

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyc.common.constants.ArouterPath
import com.dyc.module_login.R
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.register_fragment.*



@Route(path = ArouterPath.PATH_REGISTER)
class RegisterFragment : Fragment() {


//    @Autowired(name = "name",desc = "用户名",required = true)
//     var name :String = ""
//
//    @Autowired(name = "password" ,desc = "密码",required = true)
//     var password :String =""


    private lateinit var viewModel: RegisterViewModel

    private var name :String? = ""
    private var password :String? = ""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null){
             name = arguments?.getString("name")
             password = arguments?.getString("password")
        }

        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        tv_username_password.text = "$name ....$password"


    }

}