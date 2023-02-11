package com.paulklauser.composefun

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    maintenanceRepository: MaintenanceRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState(
        maintenanceRepository.getMaintenanceItems().firstOrNull {
            it.id == savedStateHandle[DETAIL_ID_KEY]
        }
    ))
    val uiState = _uiState.asStateFlow()

}