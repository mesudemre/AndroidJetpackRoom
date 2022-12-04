package com.mesutemre.androidjetpackroom.kisi_ekle

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun KisiEklemeScreen(viewModel: KisiEklemeViewModel = hiltViewModel()) {
    val state = viewModel.state.collectAsState()
    val onChangeAd = remember<(String) -> Unit> {
        {
            viewModel.onChangeAd(it)
        }
    }
    val onChangeSoyad = remember<(String) -> Unit> {
        {
            viewModel.onChangeSoyad(it)
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Ad")
                BasicTextField(
                    value = state.value.ad, onValueChange = onChangeAd, modifier = Modifier
                        .height(32.dp)
                        .padding(start = 36.dp)
                        .border(
                            width = 1.dp, shape = RoundedCornerShape(
                                4.dp
                            ), color = MaterialTheme.colorScheme.tertiary
                        )
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Soyad")
                BasicTextField(
                    value = state.value.soyad,
                    onValueChange = onChangeSoyad,
                    modifier = Modifier
                        .height(32.dp)
                        .padding(start = 12.dp)
                        .border(
                            width = 1.dp, shape = RoundedCornerShape(
                                4.dp
                            ), color = MaterialTheme.colorScheme.tertiary
                        )
                        .fillMaxWidth()
                )
            }
            Button(onClick = {
                             viewModel.saveUser()
            }, modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(top = 24.dp)) {
                Text(text = "Kaydet")
            }
        }
    }
}