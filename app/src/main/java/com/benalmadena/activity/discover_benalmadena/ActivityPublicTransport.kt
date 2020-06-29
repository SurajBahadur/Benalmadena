package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_public_transport.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityPublicTransport:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_public_transport,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        link_1_tranport.setOnClickListener {
            goToWebViewScreen("","http://www.avanzabus.com/web/timetables/desde-benalmadena-todos-los-destinos-bus-timetables.html")
        }
        link_2_tranport.setOnClickListener {
            goToWebViewScreen("","http://benalmadena-arroyo.com/train-timetable.php")

        }

    }

}