package com.dyc.module_login.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.dyc.common.constants.ArouterPath
import com.dyc.module_login.R

@Route(path = ArouterPath.PATH_LOGIN)
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        ARouter.getInstance().inject(this)


    }
}