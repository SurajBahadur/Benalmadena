package com.benalmadena.activity.local_guides.beauty_nail_salons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.activity.local_guides.property.ActivityPropertyToBuy
import com.benalmadena.activity.offers_discounts.ActivityDivas
import com.benalmadena.adapter.AdapterBarNightLife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.activity_beauty_nail_salon.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityBeautyNailSalon:BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_beauty_nail_salon,container,false)
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
        listData.add(BarNightLife("Beauty Treatments in Benalmadena", R.drawable.beauty_nail_salons_3,FragmentBeautyTreatments(),"",1))

        listData.add(BarNightLife("Art of Hair", R.drawable.img_17,FragmentArtOfHair(),"",1))

        listData.add(BarNightLife("The Salon", R.drawable.img_6,FragmentTheSalon(),"",1))

        listData.add(BarNightLife("Divas Wedding Hair and Makeup", R.drawable.beauty_nail_salons_4,FragmentWeddingHair(),"",1))

        listData.add(BarNightLife("New Styles Hair & Beauty", R.drawable.img_4,ActivityPropertyToBuy(),"https://www.facebook.com/newstylesgamonal/",2))
        listData.add(BarNightLife("Diva Hair & Beauty", R.drawable.img_18,ActivityPropertyToBuy(),"http://www.divasbenalmadena.com/",2))
        listData.add(BarNightLife("Martin's Hair and Beauty Lounge", R.drawable.beauty_nail_salons_1,ActivityPropertyToBuy(),"https://www.facebook.com/MartinsHairAndBeautyLounge/",2))
        listData.add(BarNightLife("Hair Salas", R.drawable.beauty_nail_salons_2,ActivityPropertyToBuy(),"http://www.hairsalas.com/",2))
        listData.add(BarNightLife("Divas Hair & Beauty", R.drawable.img_6,FragmentHairBeauty(),"",1))



        adapterBarNightLife= AdapterBarNightLife(activity!!,listData,this)
        rv_beauty_nail_salon.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_beauty_nail_salon.adapter = adapterBarNightLife
    }
}