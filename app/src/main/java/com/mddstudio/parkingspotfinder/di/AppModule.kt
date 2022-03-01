package com.mddstudio.parkingspotfinder.di

import android.app.Application
import androidx.room.Room
import com.mddstudio.parkingspotfinder.data.ParkingDatabase
import com.mddstudio.parkingspotfinder.data.ParkingSpotRapo
import com.mddstudio.parkingspotfinder.data.ParkingSpotRapoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingDatabase(app:Application):ParkingDatabase{
        return Room.databaseBuilder(
            app,
            ParkingDatabase::class.java,
            "pkdb"
        ).build()
    }

    @Singleton
    @Provides
    fun providesParkingSpot(db:ParkingDatabase):ParkingSpotRapo{
        return ParkingSpotRapoImp(db.dao)
    }
}