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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.paulklauser.composefun.ui.theme.ComposeFunTheme

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel(),
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
                MaintenanceList(items = mainViewModel.data.collectAsState().value, onRowClicked)
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
//        items(10) {
//            MaintenanceRow(title = "Title", installDate = "Install", mileage = "Mileage")
//        }
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