package com.shs.first_project.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.shs.first_project.R
import com.shs.first_project.model.Menu

class MenuAdapter() : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private var items = arrayListOf<Menu>()
    var itemClickListener: ((Menu) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_menu_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addAll(itemList: ArrayList<Menu>) {
        items = itemList
        notifyDataSetChanged()
    }

    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleView: TextView

        init {
            titleView = view.findViewById(R.id.titleView)
        }

        fun bind(menu: Menu) {
            titleView.text = menu.name
        }
    }
}
