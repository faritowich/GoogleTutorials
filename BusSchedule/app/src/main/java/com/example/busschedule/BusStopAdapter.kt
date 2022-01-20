package com.example.busschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.busschedule.database.Schedule
import com.example.busschedule.databinding.BusStopItemBinding
import com.example.busschedule.viewmodels.BusScheduleViewModel
import java.text.SimpleDateFormat
import java.util.*

class BusStopAdapter(private val onItemClicked: (Schedule) -> Unit) :
    ListAdapter<Schedule, BusStopAdapter.BusStopViewHolder>(DiffCallback) {

    class BusStopViewHolder(private val binding: BusStopItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(schedule: Schedule) {
            binding.arrivalTimeTextView.text =
                SimpleDateFormat("h:mm a").format(Date(schedule.arrivalTime.toLong() * 1000))
            binding.stopNameTextView.text = schedule.stopName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusStopViewHolder {
        val viewHolder = BusStopViewHolder(
            BusStopItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: BusStopViewHolder, position: Int) {
        val busStopItem = getItem(position)
        holder.bind(busStopItem)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Schedule>() {

            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule): Boolean {
                return oldItem == newItem
            }
        }
    }

}