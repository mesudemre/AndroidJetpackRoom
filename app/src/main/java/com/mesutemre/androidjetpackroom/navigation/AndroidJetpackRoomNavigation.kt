package com.mesutemre.androidjetpackroom.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mesutemre.androidjetpackroom.MainScreen
import com.mesutemre.androidjetpackroom.kisi_ekle.KisiEklemeScreen

@Composable
fun AndroidJetpackRoomNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "mainscreen"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("mainscreen") {
            MainScreen(
                navController = navController
            )
        }
        composable("kisiekle") {
            KisiEklemeScreen()
        }
    }
}
