package com.benalmadena.activity.local_guides.shoping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.bar_night_life.ActivityNightlifeBenaladena
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.activity_shoping_home.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class FragmentShopingHome: BaseFragment() {

    lateinit var adapterBarNightLife: AdapterBarNightLife
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_shoping_home,container,false)
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
            BarNightLife("Shopping in Benalmadena",R.drawable.shopping_1,
                ActivityShoppingBenalmadena(),"",1)
        )
        listData.add(
            BarNightLife("Zerimar",R.drawable.shopping_2,
                ActivityNightlifeBenaladena(),"http://www.zerimar.es/",2)
        )
        listData.add(
            BarNightLife("Bitacora",R.drawable.shopping_3,
                ActivityNightlifeBenaladena(),"http://www.bitacoracoleccionismo.com/",2)
        )
        listData.add(
            BarNightLife("The Funky Frog - Gifts & Cards",R.drawable.shopping_4,
                ActivityFunkyFrog(),"",1)
        )



        adapterBarNightLife= AdapterBarNightLife(activity!!,listData,this)
        rv_shoping_home.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_shoping_home.adapter = adapterBarNightLife
    }
}