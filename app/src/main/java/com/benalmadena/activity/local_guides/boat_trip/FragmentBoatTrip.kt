package com.benalmadena.activity.local_guides.boat_trip

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.activity.offers_discounts.ActivityCaramranCooper
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_boat_trip.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class FragmentBoatTrip:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_boat_trip,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        layout_click.setOnClickListener {
            val fragment = FragmentBoatTripsBenalmadena()
            fragment.arguments = Bundle().apply {
                putString("title", "Boat Trips in Benalmadena")
            }
            addFragment(fragment, true, R.id.container_full)
        }
        layout_click1.setOnClickListener {

            val fragment = ActivityCaramranCooper()
            fragment.arguments = Bundle().apply {
                putString("title", "Catamaran Cooper")
            }
            addFragment(fragment, true, R.id.container_full)
        }
    }
}