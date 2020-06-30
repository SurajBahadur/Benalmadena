package com.benalmadena.activity.local_information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.ActivityBarsNightlife
import com.benalmadena.activity.local_guides.bar_night_life.*
import com.benalmadena.activity.offers_discounts.ActivityLaFiesta
import com.benalmadena.activity.offers_discounts.ActivityStanleyBar
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.fragment_local_information.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class FragmentLocalInformation:BaseFragment() {

    lateinit var adapterBarNightLife: AdapterBarNightLife

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_local_information,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text="Local Information"
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        initRecyclerView()
    }


    fun initRecyclerView() {
        val listData=ArrayList<BarNightLife>()
        listData.add(
            BarNightLife("Medical Centres & Hospitals", R.drawable.local_info_3,
                FragmentMedicalCenter(),"",1)
        )
        listData.add(
            BarNightLife("Police", R.drawable.local_info_10,
                FragmentPolice(),"",1)
        )
        listData.add(BarNightLife("Ambulance", R.drawable.lacal_guid_2, FragmentAmbulance(),"",1))
        listData.add(BarNightLife("Fire Brigade", R.drawable.local_info_2, FragmentFireBrigade(),"",1))

        listData.add(BarNightLife("Other Emergency Numbers", R.drawable.local_info_4, FragmentOtherEmergencyNo(),"",1))

        listData.add(
            BarNightLife("Texi Numbers", R.drawable.icon_information,
                FragmentTexiNumber(),"",1)
        )
        listData.add(
            BarNightLife("Bill & Tip Calculator", R.drawable.local_info_9,
                ActivityTabernaFlamenca(),"",1)
        )
        listData.add(
            BarNightLife("Currency Converter",
                R.drawable.img_1,
                ActivityBarsNightlife(),"https://www.osacars.es/money-exchange-rates/",2)
        )
        listData.add(
            BarNightLife("Duty Free Allowances",
                R.drawable.local_info_1,
                FragmentDutyFree(),"http://www.tivoli.es/",1)
        )
        listData.add(
            BarNightLife("Google Translate",
                R.drawable.local_info_7,
                ActivityBarsNightlife(),"https://translate.google.co.uk/",2)
        )
        listData.add(
            BarNightLife("Flight Tracker",
                R.drawable.local_info_8,
                ActivityBarsNightlife(),"https://www.flightradar24.com/36.67,-4.5/8",2)
        )
        listData.add(
            BarNightLife("Book Flight",
                R.drawable.local_info_5,
                ActivityBarsNightlife(),"http://www.skyscanner.net/",2)
        )
        listData.add(
            BarNightLife("Push Message Settings",
                R.drawable.local_info_6,
                FragmentPushNotificationSetting(),"http://www.tivoli.es/",1)
        )




        adapterBarNightLife= AdapterBarNightLife(activity!!,listData,this)
        rv_local_information.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_local_information.adapter = adapterBarNightLife

    }
}