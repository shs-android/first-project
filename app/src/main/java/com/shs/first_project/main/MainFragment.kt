package com.shs.first_project.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shs.first_project.R
import com.shs.first_project.databinding.FragmentMainBinding
import com.shs.first_project.model.Food

class MainFragment: Fragment() {
    private lateinit var foods: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        foods = listOf(
            Food("김치찌개", R.drawable.abc_ic_clear_material, "김치찌개는 매콤한 음식입니다.", listOf())
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater, R.layout.fragment_main, container, false)

        setRecyclerView(binding)
        return binding.root
    }

    private fun setRecyclerView(binding: FragmentMainBinding) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = MainAdapter(foods)
    }
}