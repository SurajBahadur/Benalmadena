package com.benalmadena.activity.local_guides.local_service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.shoping.ActivityShoppingBenalmadena
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.activity_local_services.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityLocalService :BaseFragment() {

    lateinit var adapterBarNightLife: AdapterBarNightLife

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_local_services,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        initRecyclerView()
    }


    fun initRecyclerView() {

        val listData=ArrayList<BarNightLife>()

        listData.add(
            BarNightLife("Air Condition",R.drawable.local_service_3,
                ActiviyAirConditioning(),"",1)
        )
        listData.add(
            BarNightLife("Cleaning & Change Over",R.drawable.local_service_4,
                ActivityCleaning(),"",1)
        )
        listData.add(
            BarNightLife("Electricians",R.drawable.local_service_2,
                ActivityElectricians(),"",1)
        )

        listData.add(
            BarNightLife("PC & Internet",R.drawable.local_service_7,
                ActivityPcInternet(),"",1)
        )

        listData.add(
            BarNightLife("Plumbers",R.drawable.local_service_1,
                ActivityPlumbers(),"",1)
        )

        listData.add(
            BarNightLife("Swimming Pool",R.drawable.local_service_5,
                ActivitywimmingPool(),"",1)
        )

        listData.add(
            BarNightLife("TV & Satellite",R.drawable.local_service_6,
                ActivityTv_Satellite(),"",1)
        )


        adapterBarNightLife= AdapterBarNightLife(activity!!,listData,this)
        rv_local_service.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_local_service.adapter = adapterBarNightLife
    }
}