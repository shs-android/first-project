package com.shs.first_project.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.shs.first_project.R
import com.shs.first_project.databinding.FragmentMenuBinding
import com.shs.first_project.model.Food
import com.shs.first_project.model.Menu
import com.shs.first_project.model.Recipe

class MenuFragment() : Fragment() {
    private lateinit var menuList: ArrayList<Menu>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuList = arrayListOf(
            Menu(
                "한식",
                listOf(
                    Food(
                        "김치찌개",
                        R.drawable.abc_list_selector_disabled_holo_dark,
                        "",
                        listOf(
                            Recipe(
                                "김치찌개 만들기",
                                "첫번째 ..."
                            )
                        )
                    )
                )
            ),
            Menu(
                "중식",
                listOf(
                    Food(
                        "짜장면",
                        R.drawable.abc_action_bar_item_background_material,
                        "",
                        listOf(
                            Recipe(
                                "짜장면 만들기",
                                "첫번째 ..."
                            )
                        )
                    )
                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(
            inflater, R.layout.fragment_menu, container, false
        )
        setRecyclerView(binding)
        return binding.root
    }

    private fun setRecyclerView(binding: FragmentMenuBinding) {
        binding.recyclerView.layoutManager = GridLayoutManager(context, 3)
        val menuAdapter = MenuAdapter()
        binding.recyclerView.adapter = menuAdapter
        menuAdapter.addAll(menuList)
    }
}
