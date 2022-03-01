package com.mddstudio.parkingspotfinder.data

import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ParkingSpotRapoImp(
    private val dao: ParkingSpotDao
):ParkingSpotRapo{
    override suspend fun insertParkingSpot(spot: ParkingModel) {
        dao.insertParkingSpot(spot.toParkingSpot())
    }

    override suspend fun deleteParkoingSpot(spot: ParkingModel) {
        dao.deleteSpot(spot.toParkingSpot())
    }

    override fun getParkingSpot(): Flow<List<ParkingModel>> {
        return dao.getParkingSpot().map {
            it.map {
                it.toParkingModel()
            }
        }
    }
}