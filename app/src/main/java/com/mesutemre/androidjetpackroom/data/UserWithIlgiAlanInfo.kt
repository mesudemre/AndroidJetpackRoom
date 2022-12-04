package com.mesutemre.androidjetpackroom.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithIlgiAlanInfo(
    @Embedded
    val user: UserEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val ilgiAlanList: List<UserIlgiAlan>
)
