package com.benalmadena.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.benalmadena.R
import com.benalmadena.data.OffersDiscountData
import kotlinx.android.synthetic.main.adapter_offers_discunt.view.*

class AdapterOffersDiscount(
    val context: Context,
    val list: ArrayList<OffersDiscountData>,
    val listener: (Fragment, String) -> Unit
) : RecyclerView.Adapter<AdapterOffersDiscount.MyViewHolder>() {
    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterOffersDiscount.MyViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.adapter_offers_discunt, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterOffersDiscount.MyViewHolder, position: Int) {

        holder.itemView.tv_name.text = list[position].title
        holder.itemView.iv_icon.setImageDrawable(context.getDrawable(list[position].drawable))

        holder.itemView.layout_click.setOnClickListener {
            listener.invoke(list[position].activityName,list[position].title)
        }


    }
}