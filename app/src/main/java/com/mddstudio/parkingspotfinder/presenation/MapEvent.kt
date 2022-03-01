package com.mddstudio.parkingspotfinder.presenation

import com.google.android.gms.maps.model.LatLng
import com.mddstudio.parkingspotfinder.data.ParkingSpot
import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel

sealed class MapEvent{
    object ToggleFallout:MapEvent()
    data class OnMapLongClick(val latlang:LatLng):MapEvent()
    data class InfoLongClick(val spot: ParkingModel):MapEvent()

}
