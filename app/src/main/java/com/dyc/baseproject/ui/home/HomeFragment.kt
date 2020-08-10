package com.dyc.baseproject.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.launcher.ARouter
import com.dyc.baseproject.databinding.AppFragmentHomeBinding
import com.dyc.common.constants.ArouterPath
import com.dyc.common.ui.BaseFragment
import com.dyc.common.view.afterTextChanged
import java.lang.StringBuilder
import  org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private lateinit var binding: AppFragmentHomeBinding

        private  val viewModule: HomeViewModule by viewModel()
//    private val viewModule: HomeViewModule by lazy {
//        ViewModelProvider(
//            this,
//            InjectorUtils.provideHomeModuleFactory()
//        ).get(HomeViewModule::class.java)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppFragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun initView() {


    }

    override fun initData() {

        viewModule.wanParts.observe(viewLifecycleOwner, Observer {

            val listDatas = it.data

            var datas  =StringBuilder()
            listDatas.withIndex().forEach{ item->
                datas.append("${item.index}  ${item.value}").append(System.lineSeparator())
            }
            binding.username.text = datas.toString()
        })




        val editText = EditText(this.context)

        editText.afterTextChanged {

        }

        val sum :Int.(Int) ->Int = {other ->plus(other)}

        1.sum(2)


        binding.appLoginButton.setOnClickListener {

            /**
             * 根据测试 api 请求跟随Activity/fragment周期
             */
//            for (i in 1..100) {
                viewModule.doLogin()
//            }


        }

        //登录模块
        binding.btnLogin.setOnClickListener {
            ARouter.getInstance().build(ArouterPath.PATH_LOGIN).navigation()
        }
    }

}