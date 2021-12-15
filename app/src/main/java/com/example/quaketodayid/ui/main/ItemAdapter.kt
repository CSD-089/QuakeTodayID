package com.example.quaketodayid.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.quaketodayid.R
import com.example.quaketodayid.data.model.GempaItem
import com.example.quaketodayid.databinding.GempaItemBinding
import com.example.quaketodayid.ui.detail.DetailGempaActivity
import com.example.quaketodayid.utils.toGreen
import com.example.quaketodayid.utils.toRed
import com.example.quaketodayid.utils.toYellow

class ItemAdapter(private val data: List<GempaItem>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = GempaItemBinding.bind(view)
        fun bind(entity: GempaItem) {
            val magnitude = entity.magnitude?.toDouble()
            binding.cardView.toGreen()
            with(binding) {
                itemTime.text = "${entity.tanggal} ${entity.jam}"
                itemLocation.text = entity.wilayah
                itemMagnitude.text = "${entity.magnitude}SR"
                if (magnitude != null) {
                    when (magnitude) {
                        in 0.0..4.9 -> {
                            itemMagnitude.setTextColor(
                                ContextCompat.getColor(binding.root.context, android.R.color.black)
                            )
                            cardView.toGreen()
                        }
                        in 5.0..6.9 -> {
                            itemMagnitude.setTextColor(
                                ContextCompat.getColor(binding.root.context, android.R.color.black)
                            )
                            cardView.toYellow()
                        }
                        else -> {
                            itemMagnitude.setTextColor(
                                ContextCompat.getColor(binding.root.context, android.R.color.white)
                            )
                            cardView.toRed()
                        }
                    }
                }
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context,DetailGempaActivity::class.java)
                intent.putExtra("data",entity)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.gempa_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}