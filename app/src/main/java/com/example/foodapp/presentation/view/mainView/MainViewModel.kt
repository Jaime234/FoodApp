package com.example.foodapp.presentation.view.mainView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.domain.useCases.GetMealByIngredient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getMealByIngredient: GetMealByIngredient) :
    ViewModel() {

    private val _mealList = MutableLiveData<List<MealModel>>()
    val mealList: LiveData<List<MealModel>> = _mealList

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMealsByIngredient() {
        viewModelScope.launch {
            _isLoading.value = true
            val res = query.value?.let { getMealByIngredient(it) }
            _mealList.value = res?.meals ?: emptyList()
            _isLoading.value = false
        }
    }

    fun onQueryChange(query: String) {
        _query.value = query
    }


}