package com.mesutemre.androidjetpackroom.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mesutemre.androidjetpackroom.data.DepartmentEntity

@Dao
interface DepartmentDao {

    @Query("SELECT * FROM DepartmentEntity")
    fun getDepartmentList(): List<DepartmentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDepartment(vararg departments: DepartmentEntity)
}