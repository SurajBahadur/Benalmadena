package com.benalmadena.activity.local_guides.property

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.benalmadena.R
import com.benalmadena.activity.offers_discounts.ActivityDiscountHotelPueblo
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_holiday_letting.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityHolidayLettings:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_holiday_letting,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        layout_click.setOnClickListener {
//            val intent= Intent(this,ActivityCasaAnnabel::class.java)
//            intent.putExtra("title","Casa Annabel")
//            startActivity(intent)
            changeFragment(ActivityCasaAnnabel(),"Casa Annabel")
        }
        layout_click1.setOnClickListener {
//            val intent= Intent(this,ActivityCasaChritabel::class.java)
//            intent.putExtra("title","Casa Christabel")
//            startActivity(intent)

            changeFragment(ActivityCasaChritabel(),"Casa Christabel")
        }
        layout_click2.setOnClickListener {
//            val intent= Intent(this,ActivityDiscountHotelPueblo::class.java)
//            intent.putExtra("title","Hotel Pueblo")
//            startActivity(intent)

            changeFragment(ActivityDiscountHotelPueblo(),"Hotel Pueblo")
        }

    }
    fun changeFragment(frag: Fragment, title:String){
        val fragment =frag
        fragment.arguments = Bundle().apply {
            putString("title",title)
        }
        addFragment(fragment, true, R.id.container_full)
    }
}