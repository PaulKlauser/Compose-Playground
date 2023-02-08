package com.paulklauser.composefun

class FakeMaintenanceRepository(
    private val items: List<MaintenanceItem>
) : MaintenanceRepository {

    override fun getMaintenanceItems(): List<MaintenanceItem> {
        return items
    }
}