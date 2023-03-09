package com.example.foodapp.presentation.view.mealView

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.foodapp.data.model.MealListModel
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.domain.useCases.GetMealById
import com.example.foodapp.presentation.view.mainView.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MealViewModelTest{

    @RelaxedMockK
    private lateinit var getMealById: GetMealById

    private lateinit var mealViewModel: MealViewModel

    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        mealViewModel = MealViewModel(getMealById)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun getMeal() = runTest{

        //Given
        val list = MealListModel(
            listOf( MealModel(
                id = "1",
                meal = "name",
                drinkAlternate = null,
                category = "Pasta",
                area = "Italian",
                instructions = "instructions",
                thumbUrl = "https://www.themealdb.com/images/media/meals/xxrxux1503070723.jpg",
                tags = "Pasta,Italian,Easy",
                youtubeUrl = "https://www.youtube.com/watch?v=Enr7zrLrZSs",
                ingredient1 = "spaghetti",
                ingredient2 = "pancetta",
                ingredient3 = "eggs",
                ingredient4 = "Parmesan cheese",
                ingredient5 = "black pepper",
                ingredient6 = "black pepper",
                ingredient7 = "black pepper",
                ingredient8 = "black pepper",
                ingredient9 = "black pepper",
                ingredient10 = "black pepper",
                ingredient11 = "black pepper",
                ingredient12 = "black pepper",
                ingredient13 = "black pepper",
                ingredient14 = "black pepper",
                ingredient15 = "black pepper",
                ingredient16 = "black pepper",
                ingredient17 = "black pepper",
                ingredient18 = "black pepper",
                ingredient19 = "black pepper",
                ingredient20 = "black pepper",
                measure1 = "1 pound",
                measure2 = "4 ounces",
                measure3 = "4",
                measure4 = "1 cup",
                measure5 = "to taste",
                measure6 = "to taste",
                measure7 = "to taste",
                measure8 = "to taste",
                measure9 = "to taste",
                measure10 = "to taste",
                measure11 = "to taste",
                measure12 = "to taste",
                measure13 = "to taste",
                measure14 = "to taste",
                measure15 = "to taste",
                measure16 = "to taste",
                measure17 = "to taste",
                measure18 = "to taste",
                measure19 = "to taste",
                measure20 = "to taste",
                source = "source",
                imageSource = null,
                creativeCommonsConfirmed = null,
                dateModified = "2021-09-05"
            )))
        coEvery{ getMealById("1") } returns list

        //When
        mealViewModel.getMealsById("1")

        //Then
        assert(mealViewModel.meal.value == list.meals?.get(0))
        assert(mealViewModel.isLoading.value == false)
    }

}