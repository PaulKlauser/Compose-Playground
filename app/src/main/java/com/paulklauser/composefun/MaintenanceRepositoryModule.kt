package com.paulklauser.composefun

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MaintenanceRepositoryModule {
    @Binds
    abstract fun maintenanceRepository(prodMaintenanceRepository: ProdMaintenanceRepository): MaintenanceRepository
}