package com.mddstudio.parkingspotfinder.data

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingSpotDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParkingSpot(spot: ParkingSpot)

    @Delete
    suspend fun deleteSpot(spot: ParkingSpot)

    @Query("Select * from parkingspot")
    fun getParkingSpot(): Flow<List<ParkingSpot>>
}