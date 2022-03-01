package com.mddstudio.parkingspotfinder.presenation

import com.google.maps.android.compose.MapProperties
import com.mddstudio.parkingspotfinder.MapStyle
import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel

data class MapState (
    val properties:MapProperties=MapProperties(),
    val parkingSpots:List<ParkingModel> = emptyList(),
    val isFalloutMap:Boolean=false

        )