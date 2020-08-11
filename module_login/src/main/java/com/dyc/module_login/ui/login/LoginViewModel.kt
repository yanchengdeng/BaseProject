package com.dyc.module_login.ui.login

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.dyc.common.api.model.NetResult
import com.dyc.module_login.modle.User
import com.dyc.module_login.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository :LoginRepository) : ViewModel() {

    private var username : String = ""

    private var password : String = ""

    var loginSate : MutableLiveData<LoginStated> = MutableLiveData(LoginStated.ALL_EMPTY)

     val loginInfo :MutableLiveData<User> = MutableLiveData()



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

    fun  doLogin(){
        viewModelScope.launch {
            val datas = loginRepository.login(username,password)
            if (datas is NetResult.Success){
                loginInfo.postValue(datas.data)
            }else if (datas is NetResult.Error){
                ToastUtils.showShort(datas.exception.msg)
            }
        }
    }




}
