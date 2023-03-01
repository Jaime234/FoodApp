package com.example.foodapp.data.model

import com.google.gson.annotations.SerializedName

data class MealListModel (
    @SerializedName("meals") val meals : List<MealModel>?
)