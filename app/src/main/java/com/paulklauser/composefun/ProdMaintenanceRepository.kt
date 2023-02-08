package com.paulklauser.composefun

import javax.inject.Inject

class ProdMaintenanceRepository @Inject constructor() : MaintenanceRepository {

    override fun getMaintenanceItems(): List<MaintenanceItem> {
        return listOf(
            MaintenanceItem(
                "Michelin Pilot Sport 4S",
                "Oct 10, 2022",
                "125,430"
            )
        )
    }

}