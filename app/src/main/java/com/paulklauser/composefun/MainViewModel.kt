package com.paulklauser.composefun

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _data = MutableStateFlow(listOf(
        MaintenanceItem(
            "Michelin Pilot Sport 4S",
            "Oct 10, 2022",
            "125,430"
        )
    ))
    val data = _data.asStateFlow()

}