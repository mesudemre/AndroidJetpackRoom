package com.mesutemre.androidjetpackroom.kisi_ekle

import com.mesutemre.androidjetpackroom.data.DepartmentEntity
import com.mesutemre.androidjetpackroom.data.IlgiAlanEntity

data class KisiBilgi(
    val ad:String = "",
    val soyad:String = "",
    val ilgiAlanListe: List<IlgiAlanEntity> = emptyList(),
    val departmanListe: List<DepartmentEntity> = emptyList()
)
