package com.paulklauser.composefun

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val id: String,
    maintenanceRepository: MaintenanceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        DetailUiState(
            maintenanceRepository.getMaintenanceItems().firstOrNull { it.id == id })
    )
    val uiState = _uiState.asStateFlow()

    override fun onCleared() {
        super.onCleared()
        Log.d("DetailViewModel", "onCleared()")
    }
}