package com.mesutemre.androidjetpackroom.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithDepartentInfo(
    @Embedded
    val user: UserEntity,

    @Relation(
        parentColumn = "departman",
        entityColumn = "departmentId"
    )
    val department: DepartmentEntity
)
