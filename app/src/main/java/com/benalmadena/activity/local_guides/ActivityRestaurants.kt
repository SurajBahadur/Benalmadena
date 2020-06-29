package com.benalmadena.activity.local_guides

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.restaurants.ActivityEatingOut
import com.benalmadena.activity.local_guides.restaurants.ActivityElClubNautico
import com.benalmadena.activity.local_guides.restaurants.ActivityLaNinaDelGurdia
import com.benalmadena.activity.offers_discounts.ActivityAnicaTorres
import com.benalmadena.adapter.AdapterOffersDiscount
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.activity_restaurants.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityRestaurants:AppCompatActivity() {

    lateinit var adapterOffersDiscount: AdapterOffersDiscount;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }
        initRecyclerView()
    }
    fun initRecyclerView() {
        val listData=ArrayList<OffersDiscountData>()

        listData.add(OffersDiscountData("Eating Out",R.drawable.restaurant_2, ActivityEatingOut()))
        listData.add(OffersDiscountData("La Niña Del Guardia",R.drawable.restaurant_3,
            ActivityLaNinaDelGurdia()
        ))
        listData.add(OffersDiscountData("Anica Torres Restaurante",R.drawable.img_3,ActivityAnicaTorres()))
        listData.add(OffersDiscountData("El Club Nautico",R.drawable.restaurant_1,
            ActivityElClubNautico()
        ))



        adapterOffersDiscount= AdapterOffersDiscount(this,listData)
        rv_restaurant.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_restaurant.adapter = adapterOffersDiscount

    }
}