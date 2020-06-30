package com.benalmadena.activity.local_guides.wedding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benalmadena.R
import com.benalmadena.activity.local_guides.beauty_nail_salons.FragmentWeddingHair
import com.benalmadena.activity.local_guides.car_hire.FragmentCarHireBenalmadena
import com.benalmadena.activity.offers_discounts.ActivityOsaCarHire
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_wedding_spain.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class FragmentWeddingSpain:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wedding_spain,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        layout_click.setOnClickListener {
            val fragment = FragmentWeddingInBenalmadena()
            fragment.arguments = Bundle().apply {
                putString("title", "Boat Trips in Benalmadena")
            }
            addFragment(fragment, true, R.id.container_full)
        }
        layout_click1.setOnClickListener {

            val fragment = FragmentWeddingHair()
            fragment.arguments = Bundle().apply {
                putString("title", "Catamaran Cooper")
            }
            addFragment(fragment, true, R.id.container_full)
        }
    }

}