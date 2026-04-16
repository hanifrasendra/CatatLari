package com.example.catatanlari

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catatanlari.databinding.ItemCatatLariBinding

class CatatLariAdapter(private val listCatatLari: ArrayList<catatLari>) :
    RecyclerView.Adapter<CatatLariAdapter.ListViewHolder>() {

    class ListViewHolder(val binding: ItemCatatLariBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemCatatLariBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listCatatLari[position]
        holder.binding.tvItemJadwal.text = item.jadwal
        holder.binding.tvItemDetail.text = "${item.jarak} km | ${item.waktu} menit"
    }

    override fun getItemCount(): Int = listCatatLari.size

    fun addData(item: catatLari) {
        listCatatLari.add(0, item)
        notifyItemInserted(0)
    }
}