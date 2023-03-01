package com.example.foodapp.presentation.view.mainView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.presentation.view.mainView.components.searcher
import com.example.foodapp.presentation.view.mainView.components.mealList
import com.example.foodapp.ui.theme.Teal200

@Composable
fun MainView(viewModel: MainViewModel, navController: NavController){
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val mealList: List<MealModel>? by viewModel.mealList.observeAsState()
    val query: String by viewModel.query.observeAsState(initial = "")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Teal200)
            .padding(20.dp)
    ){

        searcher(Modifier.align(Alignment.CenterHorizontally), query, viewModel)

        Spacer(modifier = Modifier.height(16.dp))

        mealList(isLoading, mealList , navController)

    }

}




