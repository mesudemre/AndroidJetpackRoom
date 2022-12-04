package com.mesutemre.androidjetpackroom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mesutemre.androidjetpackroom.dao.DepartmentDao
import com.mesutemre.androidjetpackroom.dao.IlgiAlanDao
import com.mesutemre.androidjetpackroom.dao.UserDao
import com.mesutemre.androidjetpackroom.data.*

@Database(
    entities = [
        UserEntity::class,
        DepartmentEntity::class,
        IlgiAlanEntity::class,
        UserIlgiAlan::class
    ],
    version = 2
)
abstract class AndroidJetpackRoomAppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getDepartmentDao(): DepartmentDao
    abstract fun getIlgiAlanDao(): IlgiAlanDao
}