package com.benalmadena.activity.local_guides.bar_night_life

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.layout_find_us_common.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityHereAtLast:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_here_at_last,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        setFindUsValue()
    }


    fun setFindUsValue() {
        tv_address_find_us.text = "avenida antonio machado 76 pueblo santa ana local 3, 29630 Benalmádena"
        ll_email.visibility = View.GONE
        ll_tel.visibility = View.GONE
        ll_website.visibility = View.GONE

        tv_facebook_find_us.setOnClickListener {
            goToWebViewScreen("", "https://www.facebook.com/HereALast/")
        }
    }
}