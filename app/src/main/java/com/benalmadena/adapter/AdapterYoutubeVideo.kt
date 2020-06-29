package com.benalmadena.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.data.YoutubeVideoData
import com.benalmadena.utils.CommonFunction
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_youtube_video.view.*

class AdapterYoutubeVideo(val context: Context,val list: ArrayList<YoutubeVideoData>):RecyclerView.Adapter<AdapterYoutubeVideo.MyViewHolder>() {
    class MyViewHolder  (v: View):RecyclerView.ViewHolder(v){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterYoutubeVideo.MyViewHolder {
        val itemView=
            LayoutInflater.from(context).inflate(R.layout.adapter_youtube_video,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterYoutubeVideo.MyViewHolder, position: Int) {
        Glide.with(context).load(list[position].image.trim())
            .apply(CommonFunction.imageRequestOption(context)).into(holder.itemView.imageView3)

        holder.itemView.tv_title_video.text=list[position].title
        holder.itemView.tv_title_discription.text=list[position].description
        holder.itemView.tv_time_video.text=list[position].duration

        holder.itemView.video_click.setOnClickListener {
            ActivityWebView.start(context,"",list[position].url)
        }

    }
}