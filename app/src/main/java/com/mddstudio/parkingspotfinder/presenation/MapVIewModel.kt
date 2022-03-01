package com.mddstudio.parkingspotfinder.presenation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.mddstudio.parkingspotfinder.MapStyle
import com.mddstudio.parkingspotfinder.data.ParkingSpotRapo
import com.mddstudio.parkingspotfinder.domain.Model.ParkingModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapVIewModel  @Inject constructor(
    private val rapo: ParkingSpotRapo
):ViewModel() {
    var state by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            rapo.getParkingSpot().collectLatest {
                state=state.copy(
                    parkingSpots = it
                )
            }
        }
    }
    fun onEvent(event: MapEvent){
        when(event){
            is MapEvent.ToggleFallout->{
                state=state.copy(properties = state.properties.copy(mapStyleOptions = if (state.isFalloutMap){
                    null
                }else MapStyleOptions(MapStyle.json)
                ),
                    isFalloutMap = !state.isFalloutMap
                )

            }
            is MapEvent.OnMapLongClick->{
                viewModelScope.launch {
                    rapo.insertParkingSpot(ParkingModel(event.latlang.latitude,event.latlang.longitude))
                }
            }
            is MapEvent.InfoLongClick->{
                viewModelScope.launch {
                    rapo.deleteParkoingSpot(event.spot)
                }
            }
        }
    }
}