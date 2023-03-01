package com.example.foodapp.domain.useCases

import com.example.foodapp.data.model.MealListModel
import com.example.foodapp.data.repository.MealRepository
import javax.inject.Inject

class GetMealById @Inject constructor(private val repository: MealRepository) {

    suspend operator fun invoke(id: String): MealListModel? {
        return repository.getMealById(id)
    }

}