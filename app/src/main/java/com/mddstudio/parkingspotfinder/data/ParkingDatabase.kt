package com.mddstudio.parkingspotfinder.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ParkingSpot::class], version = 1)
abstract class ParkingDatabase:RoomDatabase() {

    abstract val dao:ParkingSpotDao

}