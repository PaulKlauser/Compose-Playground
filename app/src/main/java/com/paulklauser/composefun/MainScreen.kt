package com.paulklauser.composefun

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.paulklauser.composefun.ui.theme.ComposeFunTheme

// This serves as a binding between our ViewModel and our actual content
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onRowClicked: () -> Unit
) {
    MainScreenContent(
        items = mainViewModel.data.collectAsState().value,
        onRowClicked = onRowClicked
    )
}

// This allows us to use this for preview without needing our Fakes
@Composable
private fun MainScreenContent(
    items: List<MaintenanceItem>,
    onRowClicked: () -> Unit
) {
    ComposeFunTheme {
        Scaffold(topBar = {
            TopAppBar(contentPadding = WindowInsets.statusBars.asPaddingValues(),
                title = {
                    Text(text = "Apps, Yo")
                })
        }) {
            Box(Modifier.padding(paddingValues = it)) {
                MaintenanceList(items = items, onRowClicked)
            }
        }
    }
}

@Composable
private fun MaintenanceList(items: List<MaintenanceItem>, onRowClicked: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        items.forEach {
            item {
                MaintenanceRow(
                    title = it.title,
                    installDate = it.date,
                    mileage = it.mileage,
                    onRowClicked
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreenContent(
        items = listOf(
            MaintenanceItem(
                "1",
                "Title",
                "Date",
                "Mileage"
            )
        ),
        onRowClicked = {}
    )
}