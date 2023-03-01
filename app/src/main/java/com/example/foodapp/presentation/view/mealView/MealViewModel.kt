package com.example.foodapp.presentation.view.mealView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.domain.useCases.GetMealById
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val getMealById: GetMealById) :
    ViewModel() {

    private val _meal = MutableLiveData<MealModel>()
    val meal: LiveData<MealModel> = _meal

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMealsById(id: String) {
        viewModelScope.launch {
            val res =  getMealById(id)
            _meal.value = res?.meals?.get(0)
            _isLoading.value = false
        }
    }

}