package com.mddstudio.parkingspotfinder.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParkingSpot (
    val lat:Double,
    val lng:Double,
    @PrimaryKey val id:Int?=null
        )