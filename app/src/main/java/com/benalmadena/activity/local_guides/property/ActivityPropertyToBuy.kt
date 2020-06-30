package com.benalmadena.activity.local_guides.property

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_property_to_buy.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityPropertyToBuy:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_property_to_buy,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }


        layout_click.setOnClickListener {

            val fragment = ActivityDeCostProperties()
            fragment.arguments = Bundle().apply {
                putString("title", "De Costa Properties")
            }
            addFragment(fragment, true, R.id.container_full)
//            val intent= Intent(this,ActivityDeCostProperties::class.java)
//            intent.putExtra("title","De Costa Properties")
//            startActivity(intent)
        }
    }



}