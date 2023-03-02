package com.example.foodapp.presentation.view.mainView.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import com.example.foodapp.presentation.view.mainView.MainViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun searcher(
    modifier: Modifier,
    query: String,
    viewModel: MainViewModel,
){

    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier,
        value = query,
        onValueChange = {
            viewModel.onQueryChange(it)
        },

        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),

        placeholder = {
            Text(
                text = "Search...",
                color = Color.Black.copy(alpha = ContentAlpha.medium)
            )
        },

        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon",
                tint = Color.Black.copy(
                    alpha = ContentAlpha.medium
                )
            )
        },

        trailingIcon = {
            IconButton(
                onClick = {
                    keyboardController?.hide()
                    viewModel.onQueryChange("")
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Close Icon",
                    tint = Color.Black
                )
            }
        },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = Color.Black.copy(
                alpha = ContentAlpha.medium
            ),
            focusedBorderColor = Color.Black,
            cursorColor = Color.Black,
        ),

        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                viewModel.getMealsByIngredient()
                keyboardController?.hide()
            }
        )
    )
}