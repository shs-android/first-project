package com.shs.first_project.main

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shs.first_project.R
import com.shs.first_project.model.Food
import com.shs.first_project.model.Menu


class MainAdapter(private val items: List<Food>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_main_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val foodContentView: TextView
        private val foodImageView: ImageView

        init {
            foodContentView = view.findViewById(R.id.foodContentView)
            foodImageView = view.findViewById(R.id.foodImageView)
        }
        fun bind(food: Food) {
            foodContentView.text = food.content
            foodImageView.setImageResource(food.image)
        }
    }
}