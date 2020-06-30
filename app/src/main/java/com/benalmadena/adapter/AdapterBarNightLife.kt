package com.benalmadena.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benalmadena.R
import com.benalmadena.activity.local_guides.ActivityBarsNightlife
import com.benalmadena.base.BaseFragment
import com.benalmadena.data.BarNightLife
import kotlinx.android.synthetic.main.adapter_offers_discunt.view.*

class AdapterBarNightLife(
    val context: Context,
    val list: ArrayList<BarNightLife>,
    val activity: BaseFragment
) : RecyclerView.Adapter<AdapterBarNightLife.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterBarNightLife.MyViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(R.layout.adapter_offers_discunt, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdapterBarNightLife.MyViewHolder, position: Int) {
        holder.itemView.tv_name.text = list[position].title
        holder.itemView.iv_icon.setImageDrawable(context.getDrawable(list[position].drawable))

        holder.itemView.layout_click.setOnClickListener {
            if (list[position].type == 1) {
                val fragment = list[position].activityName
                fragment.arguments = Bundle().apply {
                    putString("title", list[position].title)
                }
                activity.addFragment(fragment, true, R.id.container_full)
            } else {
                activity.goToWebViewScreen("", list[position].url)
            }
        }
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }
}