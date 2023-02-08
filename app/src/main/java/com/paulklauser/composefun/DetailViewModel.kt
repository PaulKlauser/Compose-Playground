package com.paulklauser.composefun

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val maintenanceRepository: MaintenanceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState(null))
    val uiState = _uiState.asStateFlow()

    // Don't love that this needs to exist. This is a product of AssistedInject not existing
    // For Hilt ViewModels.
    fun load(id: String) {
        _uiState.value =
            DetailUiState(maintenanceRepository.getMaintenanceItems().firstOrNull { it.id == id })
    }

}