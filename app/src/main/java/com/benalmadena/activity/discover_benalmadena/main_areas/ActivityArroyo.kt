package com.benalmadena.activity.discover_benalmadena.main_areas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_arroyo.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityArroyo:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_arroyo,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener {
            activity!!.onBackPressed()
        }

        link_1_arroy.setOnClickListener {
            goToWebViewScreen("",link_1_arroy.text.toString())
        }
    }

}