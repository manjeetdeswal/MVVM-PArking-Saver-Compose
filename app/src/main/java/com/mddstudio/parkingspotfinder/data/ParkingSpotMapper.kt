package com.mddstudio.parkingspotfinder.data

import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel

fun ParkingSpot.toParkingModel():ParkingModel{
    return ParkingModel(
        lat = lat,
        lng = lng,
        id=id
    )
}

fun ParkingModel.toParkingSpot():ParkingSpot{
    return ParkingSpot(
        lat = lat,
        lng = lng,
        id=id
    )
}