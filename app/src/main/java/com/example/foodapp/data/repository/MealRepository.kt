package com.example.foodapp.data.repository

import com.example.foodapp.data.model.MealListModel
import com.example.foodapp.data.model.MealProvider
import com.example.foodapp.data.network.MealService
import javax.inject.Inject


class MealRepository @Inject constructor(private val api : MealService, private val mealProvider: MealProvider){

    suspend fun getMealByIngredient(query : String): MealListModel?{
        val res = api.getMealsByIngredient(query)
        mealProvider.meals = res
        return res
    }

    suspend fun getMealById(id : String): MealListModel?{
        val res = api.getMealsById(id)
        mealProvider.meals = res
        return res
    }
}