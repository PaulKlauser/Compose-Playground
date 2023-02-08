package com.paulklauser.composefun

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    maintenanceRepository: MaintenanceRepository
) : ViewModel() {

    private val _data = MutableStateFlow(maintenanceRepository.getMaintenanceItems())
    val data = _data.asStateFlow()

}