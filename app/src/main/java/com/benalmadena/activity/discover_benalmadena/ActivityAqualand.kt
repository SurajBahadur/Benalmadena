package com.benalmadena.activity.discover_benalmadena

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_aqualand.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityAqualand:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_aqualand,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener {
            activity!!.onBackPressed()
        }

        tv_link_aqua.setOnClickListener {
            val fragment = ActivityWebView()
            fragment.arguments = Bundle().apply {
                putString("title", "")
                putString("url", "https://www.aqualand.es/")
            }
            addFragment(fragment, true, R.id.container_full)
        }
        img_aqua_map.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:36.625958, -4.508219")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            mapIntent.resolveActivity(activity!!.packageManager)?.let {
                startActivity(mapIntent)
            }
        }
    }



}