package com.benalmadena.activity.local_guides.property

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_property_to_rent.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityPropertyToRent:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_property_to_rent,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text=arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }

        layout_click.setOnClickListener {
//            val intent= Intent(this,ActivityCasaAnnabel::class.java)
//            intent.putExtra("title","Casa Annabel")
//            startActivity(intent)
//

            val fragment = ActivityCasaAnnabel()
            fragment.arguments = Bundle().apply {
                putString("title", "Casa Annabel")
            }
            addFragment(fragment, true, R.id.container_full)
        }
        layout_click1.setOnClickListener {
//            val intent= Intent(this,ActivityCasaChritabel::class.java)
//            intent.putExtra("title","Casa Christabel")
//            startActivity(intent)


            val fragment = ActivityCasaChritabel()
            fragment.arguments = Bundle().apply {
                putString("title", "Casa Christabel")
            }
            addFragment(fragment, true, R.id.container_full)
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_property_to_rent)
//
//
//        tv_title.text=intent.getStringExtra("title")
//        btn_back.setOnClickListener { finish() }
//
//    }
}