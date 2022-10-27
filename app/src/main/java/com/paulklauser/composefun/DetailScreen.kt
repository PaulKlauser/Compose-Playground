package com.paulklauser.composefun

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.paulklauser.composefun.ui.theme.ComposeFunTheme

@Composable
fun Detail(goBack: () -> Unit) {
    ComposeFunTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = goBack,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(text = "Go Back")
            }
        }
    }
}