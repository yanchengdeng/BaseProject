package com.dyc.module_main.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.dyc.common.constants.ArouterPath
import com.dyc.common.ui.BaseFragment
import com.dyc.common.view.afterTextChanged
import com.dyc.module_main.databinding.AppFragmentHomeBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import kotlinx.android.synthetic.main.app_fragment_home.*
import java.lang.StringBuilder
import  org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private lateinit var binding: AppFragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AppFragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun initView() {
         val shapeCircle = ShapeAppearanceModel()
        shapeCircle.toBuilder().setAllCorners(CornerFamily.ROUNDED,50f)
        Glide.with(this).load("https://pics1.baidu.com/feed/fcfaaf51f3deb48f7639149554b44e2e2cf57858.jpeg?token=47409b39a3b31016c3684e602b6dc176").into(circle_image)
        circle_image.shapeAppearanceModel = shapeCircle

    }

    override fun initData() {

        viewModel.wanParts.observe(viewLifecycleOwner, Observer {

            val listDatas = it

            var datas = StringBuilder()
            listDatas.withIndex().forEach { item ->
                datas.append("${item.index}  ${item.value}").append(System.lineSeparator())
            }
            binding.username.text = datas.toString()
        })


        val editText = EditText(this.context)

        editText.afterTextChanged {

        }

        val sum: Int.(Int) -> Int = { other -> plus(other) }

        1.sum(2)


        binding.appLoginButton.setOnClickListener {

            /**
             * 根据测试 api 请求跟随Activity/fragment周期
             */
//            for (i in 1..100) {
            viewModel.doLogin()
//            }


        }

        //登录模块
        binding.btnLogin.setOnClickListener {
            ARouter.getInstance().build(ArouterPath.PATH_LOGIN).navigation()
        }
    }

}