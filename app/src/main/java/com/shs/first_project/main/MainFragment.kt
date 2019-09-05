package com.shs.first_project.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.shs.first_project.R
import com.shs.first_project.databinding.FragmentMainBinding
import com.shs.first_project.model.Food
import com.shs.first_project.model.Menu

class MainFragment: Fragment() {
    val args: MainFragmentArgs by navArgs()

    private lateinit var menu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        menu = args.menu
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
        binding.recyclerView.adapter = MainAdapter(menu.foods)
    }
}