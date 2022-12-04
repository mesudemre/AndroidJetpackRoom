package com.mesutemre.androidjetpackroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mesutemre.androidjetpackroom.data.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserEntity")
    fun getUserListe(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE id=:userId")
    fun getUserById(userId: Int): UserEntity

    @Insert
    fun insertUsers(vararg users: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Transaction
    @Query("SELECT * FROM UserEntity")
    fun getUserListWithDepartmanAd(): List<UserWithDepartentInfo>

    @Transaction
    @Query("SELECT * FROM UserEntity")
    fun getUserIlgiAlanList(): List<UserWithIlgiAlanInfo>

    @Insert
    fun insertUserIlgiAlan(vararg userIlgiAlan: UserIlgiAlan)

    @Query(
        "SELECT u.*,i.* FROM UserEntity u JOIN UserIlgiAlan uia ON u.id=uia.userId JOIN IlgiAlanEntity i ON uia.iaId=i.ilgiAlanId"
    )
    fun getIlgiAlanListWithMap(): Flow<Map<UserEntity,List<IlgiAlanEntity>>>
}