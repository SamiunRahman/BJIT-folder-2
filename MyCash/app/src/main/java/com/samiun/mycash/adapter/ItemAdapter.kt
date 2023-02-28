package com.samiun.mycash.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.samiun.mycash.R
import com.samiun.mycash.model.History


class ItemAdapter(
    private val context: Context,
    private val dataset: MutableList<History>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val number: TextView = view.findViewById(R.id.item_number)
        val amount: TextView = view.findViewById(R.id.item_amount)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.number.text = dataset[position].number
        holder.amount.text = "- $: "+dataset[position].amount
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}