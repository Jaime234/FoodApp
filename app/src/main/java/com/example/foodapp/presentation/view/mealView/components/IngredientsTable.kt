package com.example.foodapp.presentation.view.mealView.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodapp.data.model.MealModel
import kotlin.reflect.full.memberProperties

@Composable
fun IngredientsTable(meal: MealModel?){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                meal?.let { meal ->
                    Text(
                        text = "Ingredients :",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )

                    for (i in 1..20) {
                        val ingredientProp = MealModel::class.memberProperties
                            .firstOrNull { it.name == "ingredient$i" }
                        val ingredient = ingredientProp?.get(meal) as? String
                        if (!ingredient.isNullOrEmpty()) {
                            Text(
                                text = "- $ingredient",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                meal?.let { meal ->
                    Text(
                        text = "Measures :",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp)
                    )

                    for (i in 1..20) {
                        val measureProp = MealModel::class.memberProperties
                            .firstOrNull { it.name == "measure$i" }
                        val measure = measureProp?.get(meal) as? String
                        if (!measure.isNullOrEmpty()) {
                            Text(
                                text = "- $measure",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}