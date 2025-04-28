package bts.sio.azurimmo.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.azurimmo.viewmodels.BatimentViewModel
import bts.sio.azurimmo.model.Batiment
import androidx.navigation.NavController

@Composable
fun BatimentList(navController: NavController, viewModel: BatimentViewModel = viewModel()) {
    val batiments by viewModel.batiments.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(batiments) { batiment ->
                BatimentCard(batiment = batiment) {
                    navController.navigate("batiments/${batiment.id}")
                }
            }
        }
    }
}