package com.benalmadena

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benalmadena.activity.ActivityOffersDiscount
import com.benalmadena.activity.discover_benalmadena.ActivityDiscoverBenalmaden
import com.benalmadena.activity.local_guides.ActivityLocalGuidesServices
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_find_us_common.*

class MainActivity : BaseFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_offers_discount.setOnClickListener(this)
        btn_discover.setOnClickListener(this)
        btn_local_guid.setOnClickListener(this)
        btn_local_info.setOnClickListener(this)
        btn_radio.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v) {
            btn_offers_discount -> {
                addFragment(ActivityOffersDiscount(), true, R.id.container_full)
            }
            btn_discover -> {
                addFragment(ActivityDiscoverBenalmaden(), true, R.id.container_full)
            }
            btn_local_guid -> {
                addFragment(ActivityLocalGuidesServices(), true, R.id.container_full)
            }
            btn_local_info -> {

            }
            btn_radio -> {

            }
        }
    }
}

