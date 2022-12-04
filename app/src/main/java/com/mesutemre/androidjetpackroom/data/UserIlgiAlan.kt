package com.mesutemre.androidjetpackroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserIlgiAlan(

    @PrimaryKey(autoGenerate = true)
    val userIlgiAlanId:Int? = null,

    @ColumnInfo(name = "userId")
    val userId:Int,

    @ColumnInfo(name = "iaId")
    val iaId:Int,

    @ColumnInfo(name = "iaName")
    val iaName:String
)
