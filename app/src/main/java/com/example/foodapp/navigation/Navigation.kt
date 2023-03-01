package com.example.foodapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.foodapp.presentation.view.mainView.MainView
import com.example.foodapp.presentation.view.mainView.MainViewModel
import com.example.foodapp.presentation.view.mealView.MealView
import com.example.foodapp.presentation.view.mealView.MealViewModel

@Composable
fun Navigation(mainViewModel: MainViewModel, mealViewModel: MealViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainView.route){
        composable(route = Screen.MainView.route){
            MainView(viewModel= mainViewModel, navController = navController)
        }
        composable(
            route = Screen.MealView.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                }
            )
        ){
            entry ->
            entry.arguments?.getString("id")?.let { MealView(viewModel = mealViewModel, id = it) }
        }
    }
}