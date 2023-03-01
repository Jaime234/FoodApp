package com.example.foodapp.data.network

import com.example.foodapp.data.model.MealListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MealService @Inject constructor(private val api : MealApiClient) {

    suspend fun getMealsByIngredient(query: String): MealListModel?{
        return withContext(Dispatchers.IO) {
            val res = api.getMealsByIngredient(query)
            res.body()
        }
    }

    suspend fun getMealsById(id: String): MealListModel?{
        return withContext(Dispatchers.IO) {
            val res = api.getMealsById(id)
            res.body()
        }
    }
}