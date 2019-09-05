package com.shs.first_project.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
                R.drawable.doenjang_jjigae,
                listOf(
                    Food(
                        "된장찌개",
                        R.drawable.doenjang_jjigae,
                        "된장을 푼 물에 갖은 재료를 넣어 끓인 찌개로 토장찌개라고도 불린다.",
                        listOf(
                            Recipe(
                                "김치찌개 만들기",
                                "첫번째 ...",
                                R.drawable.doenjang_jjigae
                            )
                        )
                    )
                )
            ),
            Menu(
                "중식",
                R.drawable.noodles_with_black_bean_sauce,
                listOf(
                    Food(
                        "짜장면",
                        R.drawable.noodles_with_black_bean_sauce,
                        "",
                        listOf(
                            Recipe(
                                "짜장면 만들기",
                                "첫번째 ...",
                                R.drawable.noodles_with_black_bean_sauce
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
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        val menuAdapter = MenuAdapter().apply {
            itemClickListener = {
                val action = MenuFragmentDirections.actionMenuFragmentToMainFragment(it)
                findNavController().navigate(action)
            }
        }
        binding.recyclerView.adapter = menuAdapter
        menuAdapter.addAll(menuList)
    }
}
