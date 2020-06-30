package com.benalmadena.activity.local_guides.property

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.local_service.ActivityCleaning
import com.benalmadena.activity.local_guides.local_service.ActivityElectricians
import com.benalmadena.activity.local_guides.local_service.ActivityPcInternet
import com.benalmadena.activity.local_guides.local_service.ActiviyAirConditioning
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.activty_local_property.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityPropertyHome:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activty_local_property,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        initRecyclerView()
    }

    lateinit var adapterBarNightLife: AdapterBarNightLife


    fun initRecyclerView() {
        val listData=ArrayList<BarNightLife>()
        listData.add(
            BarNightLife("Living in Benalmadena", R.drawable.main_areas_2,
                ActivityLivingBenalmadena(),"",1)
        )
        listData.add(
            BarNightLife("Property to Buy", R.drawable.local_poperty_2,
                ActivityPropertyToBuy(),"",1)
        )
        listData.add(
            BarNightLife("Property to Rent", R.drawable.local_poperty_1,
                ActivityPropertyToRent(),"",1)
        )

        listData.add(
            BarNightLife("Holiday Lettings", R.drawable.local_poperty_3,
                ActivityHolidayLettings(),"",1)
        )


        adapterBarNightLife= AdapterBarNightLife(activity!!,listData,this)
        rv_local_property.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_local_property.adapter = adapterBarNightLife
    }
}