package com.benalmadena.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.MainActivity
import com.benalmadena.R
import com.benalmadena.activity.offers_discounts.*
import com.benalmadena.adapter.AdapterOffersDiscount
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.activity_offers_discount.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityOffersDiscount:AppCompatActivity() {

    lateinit var adapterOffersDiscount: AdapterOffersDiscount;

    companion object{
        fun start(context: Context){
            val intent= Intent(context,ActivityOffersDiscount::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offers_discount)
        initOffersDiscunt()
        tv_title.text="Offers & Discounts"
        btn_back.setOnClickListener { finish() }
    }

    fun initOffersDiscunt(){
        val listData=ArrayList<OffersDiscountData>()
        listData.add(OffersDiscountData("Discount at HOTEL PUEBLO",R.drawable.img_15,ActivityDiscountHotelPueblo()))
        listData.add(OffersDiscountData("DRINKS & TAPAS OFFERS @ El Torreon",R.drawable.img_3,ActivityElTorrenon()))
        listData.add(OffersDiscountData("Café Bar Plaza España - DRINK OFFERS!",R.drawable.img_3,ActivityCafeBar()))
        listData.add(OffersDiscountData("The Salon - SPRAY TAN ONLY €20",R.drawable.img_4,ActivitySalon()))
        listData.add(OffersDiscountData("OSA CAR HIRE - FREE CAR HIRE DAYS!",R.drawable.img_8,ActivityOsaCarHire()))
        listData.add(OffersDiscountData("La Niña Del Guardia - HAPPY HOUR 16.30 - 19.30",R.drawable.img_11,ActivityLaNinaDel()))
        listData.add(OffersDiscountData("The Belgian Corner SPECIAL OFFERS",R.drawable.img_3,ActivityBelgianCorner()))
        listData.add(OffersDiscountData("Flamenco Benalmadena",R.drawable.img_13,ActivityFlamenco()))
        listData.add(OffersDiscountData("Divas - Special Offers",R.drawable.img_18,ActivityDivas()))
        listData.add(OffersDiscountData("Art of Hair SPECIAL OFFERS!",R.drawable.img_17,ActivityArtOfHair()))
        listData.add(OffersDiscountData("Catamaran Cooper - FREE BUBBLY",R.drawable.img_9,ActivityCaramranCooper()))
        listData.add(OffersDiscountData("La Fiesta - HAPPY HOUR ALL DAY EVERY DAY",R.drawable.img_12,ActivityLaFiesta()))
        listData.add(OffersDiscountData("Stanley's Bar",R.drawable.img_7,ActivityStanleyBar()))
        listData.add(OffersDiscountData("Lewis’s Irish Pub - AMAZING BEERS & COCKTAILS",R.drawable.img_5,ActivityLewisPub()))
        listData.add(OffersDiscountData("The Black Bull",R.drawable.img_3,ActivityBlackBull()))
        listData.add(OffersDiscountData("Anica Torres Restaurante",R.drawable.img_3,ActivityAnicaTorres()))

        listData.add(OffersDiscountData("Capone's Karaoke & Music Bar - FORTHCOMING EVENTS",R.drawable.img_10,ActivityKaraoke()))
        listData.add(OffersDiscountData("The Salon BARBERS DISCOUNT",R.drawable.img_6,ActivityTheSalon()))
        listData.add(OffersDiscountData("OSA - BEST EXCHANGE RATES",R.drawable.img_1,ActivityOsaExchange()))
        listData.add(OffersDiscountData("Martins Hair & Beauty - FREE CACI FACELIFT TRIAL",R.drawable.img_18,ActivityMartinsHair()))
        listData.add(OffersDiscountData("Here at Last Bar & Grill - TAPAS WITH EVRY DRINK!",R.drawable.img_3,ActivityLastBar()))

        listData.add(OffersDiscountData("Casey Dukes - Cocktail Happy Hour - 2 FOR JUST €7.50",R.drawable.img_14,ActivityCaseyDukes()))

        listData.add(OffersDiscountData("Register Your Offer!",R.drawable.img_16,ActivityRegisterOffers()))

        adapterOffersDiscount= AdapterOffersDiscount(this,listData)
        rv_offers_discount.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_offers_discount.adapter = adapterOffersDiscount


    }
}