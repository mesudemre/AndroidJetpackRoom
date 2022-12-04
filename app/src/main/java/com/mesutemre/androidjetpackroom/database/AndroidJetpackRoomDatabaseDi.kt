package com.mesutemre.androidjetpackroom.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AndroidJetpackRoomDatabaseDi {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AndroidJetpackRoomAppDatabase::class.java,
        "users_database"
    ).addMigrations(MIGRATION_1TO2)
        .build()

    @Provides
    fun provideUserDao(database: AndroidJetpackRoomAppDatabase) = database.getUserDao()

    @Provides
    fun provideDepartmentDao(database: AndroidJetpackRoomAppDatabase) = database.getDepartmentDao()

    @Provides
    fun provideIlgiAlanDao(database: AndroidJetpackRoomAppDatabase) = database.getIlgiAlanDao()
}