package com.mesutemre.androidjetpackroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mesutemre.androidjetpackroom.data.IlgiAlanEntity

@Dao
interface IlgiAlanDao {

    @Query("SELECT * FROM IlgiAlanEntity")
    fun getIlgiAlanListe(): List<IlgiAlanEntity>

    @Insert
    fun insertIlgiAlanlar(vararg ilgialanlar: IlgiAlanEntity)
}