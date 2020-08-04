package com.dyc.module_login.ui.login

import android.text.TextUtils
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.log

class LoginViewModel : ViewModel() {

    private var username : String = ""

    private var password : String = ""

    var loginSate : MutableLiveData<LoginStated> = MutableLiveData(LoginStated.ALL_EMPTY)



    fun getUserName() = username

    fun getPassword() = password




    private fun  checkParams(username : String,password : String)  {
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
             loginSate.value = LoginStated.COMPLETE_SUCCESS
         } else if (TextUtils.isEmpty(username)) {
            loginSate.value = LoginStated.USER_NAME_EMPTY
         } else if (TextUtils.isEmpty(password)) {
            loginSate.value = LoginStated.PASSWORD_EMPTY
         } else {
            loginSate.value = LoginStated.ALL_EMPTY
         }
     }

    fun setUserInfo(username: String = "", password :String ="") {
        if (!TextUtils.isEmpty(username)){
            this.username = username
        }

        if (!TextUtils.isEmpty(password)) {
            this.password = password
        }

        checkParams(this.username,this.password)

    }




}
