package com.benalmadena.activity.discover_benalmadena

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_dayo_out.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityDayOutThings : BaseFragment(), View.OnClickListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_dayo_out, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener {
            activity!!.onBackPressed()
        }
        attachClickListeners()
    }

    private fun attachClickListeners() {
        btn_tivoli_world.setOnClickListener(this)
        btn_aqualand.setOnClickListener(this)
        btn_selwo.setOnClickListener(this)
        btn_calecar.setOnClickListener(this)
        btn_sunset_beach.setOnClickListener(this)
        btn_sealife.setOnClickListener(this)
        btn_butterfly.setOnClickListener(this)
        btn_ek_ranchito.setOnClickListener(this)
        btn_tourist_train.setOnClickListener(this)
        btn_ferry_curise.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            btn_tivoli_world -> {
                goToNextScreen(this, "", "www.tivoli.es/")
            }
            btn_aqualand -> {
                val fragment = ActivityAqualand()
                fragment.arguments = Bundle().apply {
                    putString("title", "Aqualand")
                    putString("url", "")
                }
                addFragment(fragment, true, R.id.container_full)

            }
            btn_selwo -> {
                goToNextScreen(this, "", "http://selwomarina.es/en")
            }
            btn_calecar -> {
                goToNextScreen(this, "", "http://telefericobenalmadena.com/?lang=en")
            }
            btn_sunset_beach -> {
                goToNextScreen(this, "", "http://www.sunsetbeachwatersports.com/")
            }
            btn_sealife -> {

                goToNextScreen(this, "", "https://www.visitsealife.com/benalmadena/en/")
            }

            btn_butterfly -> {

                goToNextScreen(this, "", "http://www.mariposariodebenalmadena.com/en/")
            }
            btn_ek_ranchito -> {

                goToNextScreen(this, "", "http://ranchito.com/")
            }
            btn_tourist_train -> {

                goToNextScreen(
                    this,
                    "",
                    "https://www.tripadvisor.co.uk/Attraction_Review-g1079250-d4995165-Reviews-Moncho_Tren_S_A-Arroyo_de_la_Miel_Benalmadena_Costa_del_Sol_Province_of_Malaga_A.html#REVIEWS"
                )
            }
            btn_ferry_curise -> {

                goToNextScreen(this, "", "http://www.costasolcruceros.com/")
            }
        }
    }

    private fun goToNextScreen(
        activityDayOutThings: ActivityDayOutThings,
        title: String,
        url: String
    ) {
        val fragment = ActivityWebView()
        fragment.arguments = Bundle().apply {
            putString("title", title)
            putString("url", url)
        }
        addFragment(fragment, true, R.id.container_full)
    }


}