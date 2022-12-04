package com.mesutemre.androidjetpackroom

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesutemre.androidjetpackroom.dao.DepartmentDao
import com.mesutemre.androidjetpackroom.dao.IlgiAlanDao
import com.mesutemre.androidjetpackroom.dao.UserDao
import com.mesutemre.androidjetpackroom.data.DepartmentEntity
import com.mesutemre.androidjetpackroom.data.IlgiAlanEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val departmentDao: DepartmentDao,
    private val ilgiAlanDao: IlgiAlanDao,
    private val userDao: UserDao
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val departmentList = departmentDao.getDepartmentList()
            if (departmentList.isNullOrEmpty())
                insertAllDepartments()

            val ilgiAlanList = ilgiAlanDao.getIlgiAlanListe()
            if (ilgiAlanList.isNullOrEmpty())
                insertAllIlgiAlan()

            Log.d("APP_LOG", "Departmanlar ve İlgi alanları insert edildi.")
        }

    }

    fun getUserDepartmentList() {
        viewModelScope.launch(Dispatchers.IO) {
            val liste = userDao.getUserListWithDepartmanAd()
            for (l in liste) {
                Log.d(
                    "APP_LOG",
                    "Ad : " + l.user.ad + " | Soyad : " + l.user.soyad + " | Departman : " + l.department.departmentName
                )
            }
        }
    }

    fun getIlgiAlanList() {
        viewModelScope.launch(Dispatchers.IO) {
            val liste = userDao.getUserIlgiAlanList()
            for (l in liste) {
                Log.d(
                    "APP_LOG",
                    "Ad : " + l.user.ad + " | Soyad : " + l.user.soyad + " | İlgi alanları : " + l.ilgiAlanList.toString()
                )
            }
        }
    }

    fun getIlgiAlanMappedList() {
        viewModelScope.launch(Dispatchers.IO) {
            val liste = userDao.getIlgiAlanListWithMap()
            liste.collectLatest { l ->
                l.forEach {
                    Log.d(
                        "APP_LOG",
                        "Ad : " + it.key.ad + " | Soyad : " + it.key.soyad + " | User Active : " + it.key.isActive + " | İlgi alanları : " + it.value.toString()
                    )
                }
            }
        }
    }

    private fun insertAllDepartments() {
        departmentDao.insertDepartment(
            *listOf(
                DepartmentEntity(
                    departmentName = "Bilgi Teknolojileri"
                ),
                DepartmentEntity(
                    departmentName = "Genel Müdürlük"
                ),
                DepartmentEntity(
                    departmentName = "Yemekhane"
                )
            ).toTypedArray()
        )
    }

    private fun insertAllIlgiAlan() {
        ilgiAlanDao.insertIlgiAlanlar(
            *listOf(
                IlgiAlanEntity(
                    ilgiAlanAd = "Futbol"
                ),
                IlgiAlanEntity(
                    ilgiAlanAd = "Basketbol"
                ),
                IlgiAlanEntity(
                    ilgiAlanAd = "Müzik"
                )
            ).toTypedArray()
        )
    }
}