package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benalmadena.R
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityArroyo
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityBenalmadenaCosta
import com.benalmadena.activity.discover_benalmadena.main_areas.ActivityBenalmadenaPueblo
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main_areas.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityMainAreas : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_main_areas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener {
            activity!!.onBackPressed()
        }


        btn_costa.setOnClickListener {
            goToActivity(
                ActivityBenalmadenaCosta(),
                "Benalmadena Costa"
            )
        }
        btn_arroyo.setOnClickListener { goToActivity(ActivityArroyo(), "Arroyo de la Miel") }

        btn_pueblo.setOnClickListener {
            goToActivity(
                ActivityBenalmadenaPueblo(),
                "Benalmaden Pueblo"
            )
        }
    }


    fun goToActivity(fragment: Fragment, title: String) {
        val bundle = Bundle().apply {
            putString("title", title)
        }
        fragment.arguments = bundle
        addFragment(fragment, true, R.id.container_full)
    }
}