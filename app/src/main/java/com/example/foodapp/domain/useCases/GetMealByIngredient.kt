package com.example.foodapp.domain.useCases

import com.example.foodapp.data.model.MealListModel
import com.example.foodapp.data.repository.MealRepository
import javax.inject.Inject

class GetMealByIngredient @Inject constructor(private val repository: MealRepository) {

    suspend operator fun invoke(query: String): MealListModel? {
        return repository.getMealByIngredient(query)
    }

}