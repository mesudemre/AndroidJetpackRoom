package com.mesutemre.androidjetpackroom.kisi_ekle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesutemre.androidjetpackroom.dao.IlgiAlanDao
import com.mesutemre.androidjetpackroom.dao.UserDao
import com.mesutemre.androidjetpackroom.data.UserEntity
import com.mesutemre.androidjetpackroom.data.UserIlgiAlan
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiEklemeViewModel @Inject constructor(
    val userDao: UserDao,
    val ilgiAlanDao: IlgiAlanDao
):ViewModel() {

    private val _state = MutableStateFlow(KisiBilgi())
    val state: StateFlow<KisiBilgi> = _state

    fun onChangeAd(ad:String) {
        _state.update {
            it.copy(ad = ad)
        }
    }

    fun onChangeSoyad(soyad:String) {
        _state.update {
            it.copy(soyad = soyad)
        }
    }

    fun saveUser() {
        val user = UserEntity(
            id = 4,
            ad = _state.value.ad,
            soyad = _state.value.soyad,
            departmentId = 2,
            isActive = true
        )
        viewModelScope.launch (Dispatchers.IO){
            userDao.insertUsers(*listOf(user).toTypedArray())
            userDao.insertUserIlgiAlan(*listOf(
                UserIlgiAlan(
                    userId = 4,
                    iaId = 1,
                    iaName = "Futbol"
                )
            ).toTypedArray())
        }
    }
}