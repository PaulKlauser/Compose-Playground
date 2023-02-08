package com.paulklauser.composefun

interface MaintenanceRepository {
    fun getMaintenanceItems(): List<MaintenanceItem>
}