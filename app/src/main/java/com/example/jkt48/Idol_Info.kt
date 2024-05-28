package com.example.jkt48

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jkt48.R

class Idol_Info(private val listIdol: ArrayList<com.example.jkt48.Idol>): RecyclerView.Adapter<Idol_Info.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_row_idol, parent, false))
    }

    override fun getItemCount(): Int = listIdol.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, information, jiko) = listIdol[position]
        holder.photo.setImageResource(photo)
        holder.name.text = name
        holder.description.text = description

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Detail_Idol::class.java)
            intent.putExtra("name", name)
            intent.putExtra("description", description)
            intent.putExtra("information", information)
            intent.putExtra("jiko", jiko)
            intent.putExtra("photo", photo)
            holder.itemView.context.startActivities(arrayOf(intent))
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.img_photo)
        val name: TextView = itemView.findViewById(R.id.item_name)
        val description: TextView = itemView.findViewById(R.id.item_description)
    }
}