package com.dyc.baseproject.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dyc.baseproject.databinding.AppFragmentHomeBinding
import com.dyc.baseproject.utils.InjectorUtils
import com.dyc.common.ui.BaseFragment
import java.lang.StringBuilder

class HomeFragment : BaseFragment() {

    private lateinit var binding: AppFragmentHomeBinding

    //    private  val viewModule: HomeViewModule by viewModels()
    private val viewModule: HomeViewModule by lazy {
        ViewModelProvider(
            this,
            InjectorUtils.provideHomeModuleFactory()
        ).get(HomeViewModule::class.java)
    }

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


        binding.appLoginButton.setOnClickListener {

            /**
             * 根据测试 api 请求跟随Activity/fragment周期
             */
            for (i in 1..100) {
                viewModule.doLogin()
            }
        }
    }
}