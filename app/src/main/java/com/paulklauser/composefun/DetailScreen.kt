package com.paulklauser.composefun

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.paulklauser.composefun.ui.theme.ComposeFunTheme

const val DETAIL_ID_KEY = "id"

@Composable
fun DetailScreen(viewModel: DetailViewModel, goBack: () -> Unit) {
    DetailScreenContent(
        uiState = viewModel.uiState.collectAsState().value,
        goBack = goBack
    )
}

@Composable
private fun DetailScreenContent(uiState: DetailUiState, goBack: () -> Unit) {
    ComposeFunTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.align(Alignment.Center)) {
                uiState.item?.let {
                    Text(text = it.title, modifier = Modifier.testTag("title"))
                    Text(text = it.date)
                    Text(text = it.mileage)
                }
                Button(
                    onClick = goBack
                ) {
                    Text(text = "Go Back")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreenContent(
        uiState = DetailUiState(
            MaintenanceItem(
                "1",
                "Title",
                "Date",
                "Mileage"
            )
        ), goBack = {}
    )
}