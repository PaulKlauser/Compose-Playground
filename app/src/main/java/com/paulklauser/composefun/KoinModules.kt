package com.paulklauser.composefun

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModelOf(::MainViewModel)
}

val maintenanceRepositoryModule = module {
    single {
        @Suppress("USELESS_CAST")
        ProdMaintenanceRepository() as MaintenanceRepository
    }
}

val detailViewModelModule = module {
    viewModel { params -> DetailViewModel(params.get(), get()) }
}