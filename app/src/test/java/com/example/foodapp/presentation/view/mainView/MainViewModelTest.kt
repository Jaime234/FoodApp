package com.example.foodapp.presentation.view.mainView

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.foodapp.data.model.MealListModel
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.domain.useCases.GetMealByIngredient
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
import org.mockito.BDDMockito.Then


class MainViewModelTest{

    @RelaxedMockK
    private lateinit var getMealByIngredient: GetMealByIngredient

    private lateinit var mainViewModel: MainViewModel

    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        mainViewModel = MainViewModel(getMealByIngredient)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `when user searches word list is returned`() = runTest{

        //Given
        val list = MealListModel(
            listOf( MealModel(
                id = "12345",
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
        coEvery{ getMealByIngredient("name") } returns list

        //When
        mainViewModel.onQueryChange("name")
        mainViewModel.getMealsByIngredient()

        //Then
        assert(mainViewModel.query.value == "name")
        assert(mainViewModel.mealList.value == list.meals)
        assert(mainViewModel.isLoading.value == false)
    }

    @Test
    fun `when user searches empty word empty list is returned`() = runTest{

        //Given
        val list = MealListModel(
            listOf( MealModel(
                id = "12345",
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
        coEvery{ getMealByIngredient("") } returns null

        //When
        mainViewModel.onQueryChange("")
        mainViewModel.getMealsByIngredient()

        //Then
        assert(mainViewModel.query.value == "")
        assert(mainViewModel.mealList.value.isNullOrEmpty())
        assert(mainViewModel.isLoading.value == false)
    }


}