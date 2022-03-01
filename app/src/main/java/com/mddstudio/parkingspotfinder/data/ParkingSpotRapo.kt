package com.mddstudio.parkingspotfinder.data

import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRapo {

    suspend fun insertParkingSpot(spot: ParkingModel)
    suspend fun deleteParkoingSpot(spot: ParkingModel)
    fun getParkingSpot():Flow<List<ParkingModel>>
}