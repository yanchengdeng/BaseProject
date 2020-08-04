package com.dyc.baseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ActivityUtils
import com.dyc.baseproject.ui.login.LoginActivity
import com.dyc.common.view.afterTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        login_ui.setOnClickListener {
//            ARouter.getInstance().build("/login/login").navigation()

            ActivityUtils.startActivity(com.dyc.module_login.LoginActivity::class.java)
        }

        editTextTextPersonName.afterTextChanged {


        }




    }
}