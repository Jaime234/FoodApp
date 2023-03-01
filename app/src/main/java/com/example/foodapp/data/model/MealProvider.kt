package com.example.foodapp.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealProvider @Inject constructor(){
    var meals: MealListModel? = null
}