package com.dyc.module_main.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.dyc.module_main.R

class NotificationsFragment : Fragment() {


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.app_fragment_notifications, container, false)
    val textView: TextView = root.findViewById(R.id.text_notifications)
    return root
  }
}