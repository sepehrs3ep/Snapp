package ir.snapp.assignment.data.persistent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.snapp.assignment.data.persistent.vehicle.VehicleDao
import ir.snapp.assignment.models.vehicle.Vehicle

/**
 * Created by Sepehr Sadri on 6/26/2020.
 * sepehrsadri@gmail.com
 * Tehran, Iran.
 * Copyright © 2020 by Sepehr Sadri. All rights reserved.
 */
@Database(
    entities = [
        Vehicle::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao

    companion object {
        private const val DATABASE_NAME: String = "SNAPP"

        @Volatile
        private var DB_INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    if (DB_INSTANCE == null) {
                        DB_INSTANCE =
                            Room
                                .databaseBuilder(
                                    context.applicationContext,
                                    AppDatabase::class.java,
                                    DATABASE_NAME
                                )
                                .build()
                    }
                }
            }
            return DB_INSTANCE!!
        }
    }
}