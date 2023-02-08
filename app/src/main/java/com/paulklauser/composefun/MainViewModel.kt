package com.paulklauser.composefun

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    maintenanceRepository: MaintenanceRepository = ProdMaintenanceRepository()
) : ViewModel() {

    private val _data = MutableStateFlow(maintenanceRepository.getMaintenanceItems())
    val data = _data.asStateFlow()

}