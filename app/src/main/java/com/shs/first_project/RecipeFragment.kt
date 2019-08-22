package com.shs.first_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shs.first_project.databinding.FragmentRecipeBinding

class RecipeFragment(): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRecipeBinding>(
            inflater, R.layout.fragment_recipe, container, false)

        return binding.root
    }
}
