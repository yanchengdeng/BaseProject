package com.dyc.common.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 *@Author : yancheng
 *@Date : 2020/8/4
 *@Time : 10:49
 *@Describe ：
 **/

/**
 * 监听EditText  输入框变化
 */
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged.invoke(editable.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

