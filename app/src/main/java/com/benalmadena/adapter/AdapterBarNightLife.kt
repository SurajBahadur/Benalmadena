package com.benalmadena.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benalmadena.R
import com.benalmadena.activity.ActivityWebView
import com.benalmadena.data.BarNightLife
import com.bumptech.glide.load.model.ByteArrayLoader
import kotlinx.android.synthetic.main.adapter_offers_discunt.view.*

class AdapterBarNightLife(val context: Context,val list:ArrayList<BarNightLife>):RecyclerView.Adapter<AdapterBarNightLife.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterBarNightLife.MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.adapter_offers_discunt,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
    return list.size
    }

    override fun onBindViewHolder(holder: AdapterBarNightLife.MyViewHolder, position: Int) {
        holder.itemView.tv_name.text=list[position].title
        holder.itemView.iv_icon.setImageDrawable(context.getDrawable(list[position].drawable))

        holder.itemView.layout_click.setOnClickListener {
            if (list[position].type==1){
                val intent= Intent(context,list[position].activityName::class.java)
                intent.putExtra("title",list[position].title)
                context.startActivity(intent)
            }else{
                ActivityWebView.start(context,"",list[position].url)
            }
        }
    }
    class MyViewHolder  (v: View):RecyclerView.ViewHolder(v){

    }
}