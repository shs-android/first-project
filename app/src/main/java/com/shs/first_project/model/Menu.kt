package com.shs.first_project.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Menu(
    val name: String,
    val foods: List<Food>
)

@Parcelize
data class Food(
    val name: String,
    val image: Int,
    val content: String,
    val recipes: List<Recipe>
): Parcelable

@Parcelize
data class Recipe(
    val name: String,
    val description: String // 설명
): Parcelable