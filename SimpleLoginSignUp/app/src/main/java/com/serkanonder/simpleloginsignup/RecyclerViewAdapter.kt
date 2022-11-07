package com.serkanonder.simpleloginsignup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()  {

    private val itemTitles = arrayOf(
        "Recent Values",
        "My Appointments",
        "Bolus Calculator",
        "General Info",
    )

    private val itemDetails = arrayOf(
        "View your recent values",
        "View your upcoming appointments",
        "Calculate your bolus",
        "View general information",
    )


    private val itemImages = arrayOf(
        R.drawable.recent_val,
        R.drawable.medicine,
        R.drawable.calculator,
        R.drawable.general_info
    )


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var image : ImageView
        var textTitle : TextView
        var textDes : TextView

        init {
            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDes = itemView.findViewById(R.id.item_details)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_model, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDes.text = itemDetails[position]
        holder.image.setImageResource(itemImages[position])

        holder.itemView.setOnClickListener {v: View ->

            Toast.makeText(v.context, "Clicked on ${itemTitles[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }
}