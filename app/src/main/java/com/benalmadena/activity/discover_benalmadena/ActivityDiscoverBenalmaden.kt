package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_discover_benalmaden.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityDiscoverBenalmaden : BaseFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_discover_benalmaden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = "Discover Benalmadena"
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        attachClickListeners()
    }

    private fun attachClickListeners() {
        btn_history.setOnClickListener(this)
        btn_main_area.setOnClickListener(this)
        btn_facebbok.setOnClickListener(this)
        btn_video.setOnClickListener(this)
        btn_day_out_things.setOnClickListener(this)
        btn_local_news.setOnClickListener(this)
        btn_public_transport.setOnClickListener(this)
        btn_holiday_date.setOnClickListener(this)
        btn_weather.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            btn_history -> {
                goToActivity(ActivityHistoryBenalmadena(), "History of Benalmadena")
            }
            btn_main_area -> {
                goToActivity(ActivityMainAreas(), "Main Areas")
            }
            btn_facebbok -> {
                goToWebViewScreen("","https://www.facebook.com/discoverbenalmadena/")
            }
            btn_video -> {
                goToActivity(ActivityVieoBenalmadena(), "Videos of Benalmadena")
            }

            btn_day_out_things -> {
                goToActivity(ActivityDayOutThings(), "Days Out & Things to Do")
            }

            btn_local_news -> {
                goToWebViewScreen("","https://www.euroweeklynews.com/3.0.15/news/on-euro-weekly-news/costa-del-sol-malaga")
            }
            btn_public_transport -> {
                goToActivity(ActivityPublicTransport(), "Public Transport")
            }
            btn_visitor_guide -> {
                goToWebViewScreen( "", "http://benalmadena-arroyo.com/")
            }
            btn_holiday_date -> {
            }
            btn_weather -> {
            }
        }
    }

    fun goToActivity(fragment: Fragment, title: String) {
        fragment.arguments = Bundle().apply {
            putString("title", title)
        }
        addFragment(fragment, true, R.id.container_full)
    }



}