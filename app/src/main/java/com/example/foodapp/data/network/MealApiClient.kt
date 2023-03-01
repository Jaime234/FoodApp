package com.example.foodapp.data.network


import com.example.foodapp.data.model.MealListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApiClient {
    @GET("search.php")
    suspend fun getMealsByIngredient(@Query("s")query: String):Response<MealListModel>

    @GET("lookup.php")
    suspend fun getMealsById(@Query("i")id: String):Response<MealListModel>

}