package com.benalmadena.activity.discover_benalmadena

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.benalmadena.R
import com.benalmadena.adapter.AdapterYoutubeVideo
import com.benalmadena.data.YoutubeVideoData
import kotlinx.android.synthetic.main.activity_vido_benalmadena.*
import kotlinx.android.synthetic.main.layout_toolbar_common.*

class ActivityVieoBenalmadena:AppCompatActivity() {

    lateinit var adapterYoutubeVideo: AdapterYoutubeVideo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vido_benalmadena)
        tv_title.text=intent.getStringExtra("title")
        btn_back.setOnClickListener { finish() }

        initVideos()

    }

    fun initVideos(){
        val listData=ArrayList<YoutubeVideoData>()
        listData.add(YoutubeVideoData("Benalmadena Flyover","Some stunning drone footage of Benalmadena","https://img.youtube.com/vi/IF6Q_-ChAx0/0.jpg","http://www.youtube.com/embed/IF6Q_-ChAx0?autoplay=1&vq=small","01:40"))
        listData.add(YoutubeVideoData("Benalmadena Beach Walk & Tapas","Hello Explorers, hope you enjoy my Benalmadena beach walk. The tapas were delicious, and the restaurant had great views of the beach. ","https://img.youtube.com/vi/zi0MIy3W8k4/0.jpg","http://www.youtube.com/embed/zi0MIy3W8k4?autoplay=1&vq=small","03:47"))
        listData.add(YoutubeVideoData("Top 10 Places To Visit In Benalmádena, Spain","These are the top 10 places to visit in Benalmádena, as per Right Spain's recommendation.","https://img.youtube.com/vi/X18v5KrtIu8/0.jpg","http://www.youtube.com/embed/X18v5KrtIu8?autoplay=1&vq=small","3:52"))
        listData.add(YoutubeVideoData("Teleferico Benalmadena Cable Car (Descent)","The ride down in the cable car from the top of Mount Calamorro Benalmadena Spain. June 2014 ","https://img.youtube.com/vi/glQO341FFSQ/0.jpg","http://www.youtube.com/embed/glQO341FFSQ?autoplay=1&vq=small","15:25"))
        listData.add(YoutubeVideoData("Benalmádena - Video Promocional FITUR 2017","The latest video from the Benalmádena tourist board","https://img.youtube.com/vi/VS6SlxHynW8/0.jpg","http://www.youtube.com/embed/VS6SlxHynW8?autoplay=1&vq=small","2.14"))
        listData.add(YoutubeVideoData("Benalmádena en Fitur 2018","","https://img.youtube.com/vi/ItnQ2r1ewhY/0.jpg","https://youtu.be/ItnQ2r1ewhY","2.19"))

        adapterYoutubeVideo= AdapterYoutubeVideo(this,listData)
        rv_videos.layoutManager = StaggeredGridLayoutManager(1, 1)
        rv_videos.adapter = adapterYoutubeVideo
    }
}