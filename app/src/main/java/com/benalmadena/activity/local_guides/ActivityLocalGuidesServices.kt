package com.benalmadena.activity.local_guides

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.offers_discounts.ActivityDiscountHotelPueblo
import com.benalmadena.adapter.AdapterOffersDiscount
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.activity_local_guides.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityLocalGuidesServices:AppCompatActivity() {
    companion object{
        fun start(context: Context){
            val intent= Intent(context, ActivityLocalGuidesServices::class.java)
            context.startActivity(intent)
        }
    }
    lateinit var adapterOffersDiscount: AdapterOffersDiscount;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_guides)
        initLocalGuide()

        tv_title.text="Local Guides & Services"
        btn_back.setOnClickListener { finish() }
    }

    fun initLocalGuide() {
        val listData=ArrayList<OffersDiscountData>()

        listData.add(OffersDiscountData("Restaurants",R.drawable.img_3,ActivityRestaurants()))

        listData.add(OffersDiscountData("Bars & Nightlife",R.drawable.img_14,ActivityBarsNightlife()))
        listData.add(OffersDiscountData("Shopping",R.drawable.img_2,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Local Services",R.drawable.lacal_guid_1,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Property",R.drawable.lacal_guid_3,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Beauty & Nails Salons",R.drawable.lacal_guid_4,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Hair Salons",R.drawable.img_18,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Barbers",R.drawable.img_6,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Boat Trips",R.drawable.img_9,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Car Hire",R.drawable.img_8,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Weddings in Spain",R.drawable.lacal_guid_6,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Currency Exchange",R.drawable.img_1,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Golf",R.drawable.lacal_guid_5,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Pharmacies",R.drawable.lacal_guid_2,ActivityLocalGuidesServices()))
        listData.add(OffersDiscountData("Dentist",R.drawable.lacal_guid_7,ActivityLocalGuidesServices()))



        adapterOffersDiscount= AdapterOffersDiscount(this,listData)
        rv_local_guides.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_local_guides.adapter = adapterOffersDiscount

    }
}