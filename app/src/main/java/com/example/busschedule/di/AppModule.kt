package com.example.busschedule.di

import android.content.Context
import androidx.room.Room
import com.example.busschedule.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
                    app,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("database/bus_schedule.db")
                    .build()

    @Singleton
    @Provides
    fun provideScheduleDao(db: AppDatabase) = db.scheduleDao()

}