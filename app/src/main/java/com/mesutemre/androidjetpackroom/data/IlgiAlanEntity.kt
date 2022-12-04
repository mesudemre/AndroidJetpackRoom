package com.mesutemre.androidjetpackroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class IlgiAlanEntity(
    @PrimaryKey(autoGenerate = true)
    val ilgiAlanId: Int? = null,

    @ColumnInfo(name = "ilgiAlanAd")
    val ilgiAlanAd: String
)
