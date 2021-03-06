package com.benalmadena.activity.local_guides

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.beauty_nail_salons.ActivityBeautyNailSalon
import com.benalmadena.activity.local_guides.boat_trip.FragmentBoatTrip
import com.benalmadena.activity.local_guides.car_hire.FragmentCarHireHome
import com.benalmadena.activity.local_guides.hair_salon.FragmentHomeSalon
import com.benalmadena.activity.local_guides.local_service.ActivityLocalService
import com.benalmadena.activity.local_guides.property.ActivityPropertyHome
import com.benalmadena.activity.local_guides.shoping.FragmentShopingHome
import com.benalmadena.activity.local_guides.wedding.FragmentWeddingSpain
import com.benalmadena.activity.offers_discounts.ActivityOsaExchange
import com.benalmadena.activity.offers_discounts.ActivityTheSalon
import com.benalmadena.adapter.AdapterOffersDiscount
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.activity_local_guides.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityLocalGuidesServices:BaseFragment(), (Fragment, String) -> Unit {

    lateinit var adapterOffersDiscount: AdapterOffersDiscount;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_local_guides,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalGuide()

        tv_title.text="Local Guides & Services"
        btn_back.setOnClickListener { activity!!.onBackPressed() }
    }

    fun initLocalGuide() {
        val listData=ArrayList<OffersDiscountData>()

        listData.add(OffersDiscountData("Restaurants",R.drawable.img_3,ActivityRestaurants()))

        listData.add(OffersDiscountData("Bars & Nightlife",R.drawable.img_14,ActivityBarsNightlife()))
        listData.add(OffersDiscountData("Shopping",R.drawable.img_2, FragmentShopingHome()))
        listData.add(OffersDiscountData("Local Services",R.drawable.lacal_guid_1,
            ActivityLocalService()
        ))
        listData.add(OffersDiscountData("Property",R.drawable.lacal_guid_3,ActivityPropertyHome()))
        listData.add(OffersDiscountData("Beauty & Nails Salons",R.drawable.lacal_guid_4,
            ActivityBeautyNailSalon()
        ))
        listData.add(OffersDiscountData("Hair Salons",R.drawable.img_18, FragmentHomeSalon()))
        listData.add(OffersDiscountData("Barbers",R.drawable.img_6,ActivityTheSalon()))
        listData.add(OffersDiscountData("Boat Trips",R.drawable.img_9, FragmentBoatTrip()))

        listData.add(OffersDiscountData("Car Hire",R.drawable.img_8,
            FragmentCarHireHome()
        ))
        listData.add(OffersDiscountData("Weddings in Spain",R.drawable.lacal_guid_6,
            FragmentWeddingSpain()
        ))
        listData.add(OffersDiscountData("Currency Exchange",R.drawable.img_1,ActivityOsaExchange()))

        listData.add(OffersDiscountData("Golf",R.drawable.lacal_guid_5,FragmentGolf()))
        listData.add(OffersDiscountData("Pharmacies",R.drawable.lacal_guid_2,FragmentPharmacies()))


        listData.add(OffersDiscountData("Dentist",R.drawable.lacal_guid_7,FragmentDentist()))



        adapterOffersDiscount= AdapterOffersDiscount(activity!!, listData,this)
        rv_local_guides.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_local_guides.adapter = adapterOffersDiscount

    }

    override fun invoke(fragment: Fragment, title: String) {
        fragment.arguments = Bundle().apply {
            putString("title", title)
        }
        addFragment(fragment, true, R.id.container_full)
    }
}