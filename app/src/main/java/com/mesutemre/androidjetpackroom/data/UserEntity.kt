package com.mesutemre.androidjetpackroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id:Int,

    @ColumnInfo(name = "ad")
    val ad:String,

    @ColumnInfo(name = "soyad")
    val soyad:String,

    @ColumnInfo(name = "departman")
    val departmentId:Int,

    @ColumnInfo(name = "isActive")
    val isActive:Boolean
)
