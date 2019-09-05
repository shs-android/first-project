package com.shs.first_project.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Menu(
    val name: String,
    val image: Int,
    val foods: List<Food>
): Parcelable

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
    val description: String, // 설명
    val image: Int
): Parcelable