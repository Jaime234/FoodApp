package com.example.foodapp.navigation

sealed class Screen (val route: String){
    object MainView : Screen("Main_Screen")
    object MealView : Screen("Meal_Screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}