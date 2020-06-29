package com.benalmadena.activity.local_guides

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.restaurants.ActivityEatingOut
import com.benalmadena.activity.local_guides.restaurants.ActivityElClubNautico
import com.benalmadena.activity.local_guides.restaurants.ActivityLaNinaDelGurdia
import com.benalmadena.activity.offers_discounts.ActivityAnicaTorres
import com.benalmadena.adapter.AdapterOffersDiscount
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.activity_restaurants.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityRestaurants : BaseFragment(), (Fragment, String) -> Unit {


    lateinit var adapterOffersDiscount: AdapterOffersDiscount;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.finish() }
        initRecyclerView()
    }


    fun initRecyclerView() {
        val listData = ArrayList<OffersDiscountData>()

        listData.add(OffersDiscountData("Eating Out", R.drawable.restaurant_2, ActivityEatingOut()))
        listData.add(
            OffersDiscountData(
                "La Niña Del Guardia", R.drawable.restaurant_3,
                ActivityLaNinaDelGurdia()
            )
        )
        listData.add(
            OffersDiscountData(
                "Anica Torres Restaurante",
                R.drawable.img_3,
                ActivityAnicaTorres()
            )
        )
        listData.add(
            OffersDiscountData(
                "El Club Nautico", R.drawable.restaurant_1,
                ActivityElClubNautico()
            )
        )



        adapterOffersDiscount = AdapterOffersDiscount(activity!!, listData, this)
        rv_restaurant.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_restaurant.adapter = adapterOffersDiscount

    }

    override fun invoke(fragment: Fragment, title: String) {
        fragment.arguments = Bundle().apply {
            putString("title", title)
        }
        addFragment(fragment, true, R.id.container_full)
    }
}