package com.mesutemre.androidjetpackroom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DepartmentEntity(
    @PrimaryKey(autoGenerate = true)
    val departmentId:Int? = null,

    val departmentName:String
)
