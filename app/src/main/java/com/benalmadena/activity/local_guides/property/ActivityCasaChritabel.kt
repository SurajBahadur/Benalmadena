package com.benalmadena.activity.local_guides.property

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.benalmadena.R
import com.benalmadena.base.BaseFragment
import kotlinx.android.synthetic.main.activity_casa_chritabel.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityCasaChritabel:BaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_casa_chritabel,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title.text = arguments!!.getString("title")
        btn_back.setOnClickListener { activity!!.onBackPressed() }
        setPrice()

    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_casa_chritabel)
//
//        tv_title.text=intent.getStringExtra("title")
//        btn_back.setOnClickListener { finish() }
//
//        setPrice()
//    }

    fun setPrice(){
        tv_prices.text="Apr 1 - Apr 23, 2017\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Apr 24 - May 26, 2017\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "May 27 - June 4, 2017\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "June 5 - Jun 30, 2017\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 14, 2017\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 15 - Sept 3, 2017\n" +
                "Peak season £50 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 4 - Sep 30, 2017\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 13, 2017\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 14 - Nov 5, 2017\n" +
                "High season £45 per night (minimum 5 nights)\n" +
                "\n" +
                "Nov 6 - Dec 17, 2017\n" +
                "Low season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Dec 18 - Jan 2, 2018\n" +
                "Mid season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Jan 3 - Feb 9, 2018\n" +
                "Low season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 10 - Feb 25, 2018\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 26 - March 23, 2018\n" +
                "Low season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "March 24 - April 16, 2018\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "April 17 - May 25,2018\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "May 26 - Jun 3, 2018\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Jun 4 - Jun 30, 2018\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 13, 2018\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 14 - Sep 2, 2018\n" +
                "Peak season £50 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 3 - Sep 30, 2018\n" +
                "High season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 12, 2018\n" +
                "Mid season £40 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 13 - Nov 4, 2018\n" +
                "High season £ 45 per night (minimum 7 nights)\n" +
                "\n" +
                "Nov 5 - Dec 21, 2018\n" +
                "Low season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Dec 22 - Jan 6, 2019\n" +
                "Mid season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Long term winter lets available from 1st October until 31st March for a minimum of 90 nights for £20 per night for 2 people (extra people £2 per night)"




        tv_prices1.text="Apr 1 - Apr 23, 2017\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Apr 24 - May 26 2017\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "May 27- Jun 4 2017\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Jun 4- Jun 30, 2017\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 14, 2017\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 15 - Sept 3, 2017\n" +
                "Peak season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 4 - Sep 30, 2017\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 13, 2017\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 14- Nov 5, 2017\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Nov 6 - Dec 17, 2017\n" +
                "Low season £30 per night (minimum 5 nights)\n" +
                "\n" +
                "Dec 18 - Jan 2nd 2018\n" +
                "Mid season £35 per night (minimum 7 nights)\n" +
                "\n" +
                "Jan 3 - Feb 9, 2018\n" +
                "Low season £30 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 10 - Feb 25, 2018\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 26 - Mar 23, 2018\n" +
                "Low season £30 per night (minimum 5 nights)\n" +
                "\n" +
                "Mar 24 - Apr 15, 2018\n" +
                "High season £40 per night (minimum & nights)\n" +
                "\n" +
                "Apr 16 - May 25, 2018\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "May 26 - Jun 3, 2018\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Jun 4 - Jun 30, 2018\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 13, 2018\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 14 - Sep 2, 2018\n" +
                "Peak season £45 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 3 - Sep 30, 2018\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 12, 2018\n" +
                "Mid season £35 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 13 - Nov 4, 2018\n" +
                "High season £40 per night (minimum 7 nights)\n" +
                "\n" +
                "Nov 5 - Dec 21,2018\n" +
                "Low season £30 per night (minimum 7 nights)\n" +
                "\n" +
                "Dec 22 - Jan 6, 2019\n" +
                "Mid season £35 per night (minimum 7 nights)\n" +
                "\n" +
                "Long term winter lets are available from 1st October until 31st March for a minimum of 90 nights for £15 per night for two people (extra people £2 per night)."

        tv_prices2.text="Apr 1 - Apr 23, 2017\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Apr 24 -26 May, 2017\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "May 27- June 4, 2017\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "June 5 - Jun 30, 2017\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 14, 2017\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 15 - Sept 3, 2017\n" +
                "Peak season £90 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 4 - Sep 30, 2017\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 15, 2017\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 16 - Oct 29, 2017\n" +
                "High season £80 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 30 - Dec 17, 2017\n" +
                "Low season £60 per night (minimum 5 nights)\n" +
                "\n" +
                "Dec 18 -2 Jan 2018\n" +
                "Mid season £70 per night (minimum 7 nights)\n" +
                "\n" +
                "Jan 3 - Feb 8, 2018\n" +
                "Low season £60 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 9 - Feb 25, 2018\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "Feb 26 - Mar 23, 2018\n" +
                "Low season £60 per night (minimum 5 nights)\n" +
                "\n" +
                "Mar 24 - Apr 15, 2018\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Apr 16 - May 25, 2018\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "May 26- Jun 3, 2018\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Jun 4 - Jun 30, 2018\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "Jul 1 - Jul 13, 2018\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Jul 14 - Sep 2, 2018\n" +
                "Peak season £90 per night (minimum 7 nights)\n" +
                "\n" +
                "Sep 3 - Sep 30, 2018\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Oct 1 - Oct 12, 2018\n" +
                "Mid season £70 per night (minimum 5 nights)\n" +
                "\n" +
                "Oct 13 - Nov 4, 2018\n" +
                "High season £80 per night (minimum 7 nights)\n" +
                "\n" +
                "Nov 5 - Dec 21, 2018\n" +
                "Low season £60 per night (minimum 5 nights)\n" +
                "\n" +
                "Dec 22 - Jan 6, 2019\n" +
                "Mid season £70 per night (minimum 7 nights)\n" +
                "\n" +
                "Long term winter lets available from 1st October until 31st March for a minimum of 90 nights for £30 per night for 4 people (extra people £2 per night)."

    }
}