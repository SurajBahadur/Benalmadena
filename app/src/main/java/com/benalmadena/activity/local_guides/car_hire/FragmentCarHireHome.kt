package com.benalmadena.activity.local_guides.car_hire

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benalmadena.R
import com.benalmadena.activity.local_guides.boat_trip.FragmentBoatTripsBenalmadena
import com.benalmadena.activity.offers_discounts.ActivityCaramranCooper
import com.benalmadena.activity.offers_discounts.ActivityOsaCarHire
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_car_hire_home.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class FragmentCarHireHome:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_car_hire_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        layout_click.setOnClickListener {
            val fragment = FragmentCarHireBenalmadena()
            fragment.arguments = Bundle().apply {
                putString("title", "Boat Trips in Benalmadena")
            }
            addFragment(fragment, true, R.id.container_full)
        }
        layout_click1.setOnClickListener {

            val fragment = ActivityOsaCarHire()
            fragment.arguments = Bundle().apply {
                putString("title", "Catamaran Cooper")
            }
            addFragment(fragment, true, R.id.container_full)
        }
    }
    }