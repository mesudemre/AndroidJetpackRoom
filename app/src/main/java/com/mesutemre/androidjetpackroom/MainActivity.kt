package com.mesutemre.androidjetpackroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mesutemre.androidjetpackroom.navigation.AndroidJetpackRoomNavigation
import com.mesutemre.androidjetpackroom.ui.theme.AndroidJetpackRoomTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidJetpackRoomNavigation(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainActivityViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            navController.navigate("kisiekle")
        }) {
            Text(text = "Kişi Ekle")
        }

        Button(
            modifier = Modifier.padding(top = 24.dp),
            onClick = {
                viewModel.getUserDepartmentList()
            }) {
            Text(text = "Departman")
        }

        Button(
            modifier = Modifier.padding(top = 24.dp),
            onClick = {
                viewModel.getIlgiAlanMappedList()
            }) {
            Text(text = "İlgi alanları")
        }
    }
}