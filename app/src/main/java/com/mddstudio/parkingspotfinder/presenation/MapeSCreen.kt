package com.mddstudio.parkingspotfinder.presenation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker


@Composable
fun mapScreen(
    vIewModel: MapVIewModel = viewModel()
){
val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, floatingActionButton = {
        FloatingActionButton(onClick = { vIewModel.onEvent(MapEvent.ToggleFallout) }) {
            Icon(imageVector = if(vIewModel.state.isFalloutMap){
                                                           androidx.compose.material.icons.Icons.Default.ToggleOff
            }else Icons.Default.ToggleOn, contentDescription ="ToggleFallout" )

        }
    }) {
GoogleMap(
    modifier = Modifier.fillMaxSize(),
    properties = vIewModel.state.properties,
    uiSettings = MapUiSettings(zoomControlsEnabled = false),
    onMapLongClick = {
vIewModel.onEvent(MapEvent.OnMapLongClick(it))
    }
){
    vIewModel.state.parkingSpots.forEach{  spot->
        Marker(position = LatLng(spot.lat, spot.lng),
        title = "Parking Spot (${spot.lat},${spot.lng}",
        snippet = "Long Click To Delete",
            onInfoWindowLongClick = {
                vIewModel.onEvent(
                    MapEvent.InfoLongClick(spot)
                )
            },
            onClick = {
                it.showInfoWindow()
                true
            },
            icon = BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_GREEN
            )
            )
    }
}
    }
}