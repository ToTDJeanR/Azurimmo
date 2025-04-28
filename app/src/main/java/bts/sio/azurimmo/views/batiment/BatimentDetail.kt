package bts.sio.azurimmo.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import bts.sio.azurimmo.viewmodels.BatimentViewModel

@Composable
fun BatimentDetail(navController: NavController, viewModel: BatimentViewModel = viewModel(), batimentId: String){
    val batiment by viewModel.batiment.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    LaunchedEffect(batimentId) {
        viewModel.getBatiment(batimentId)
    }

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!)
        batiment != null -> {
            Column() {
                Text(text = "Adresse: ${batiment!!.adresse}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Ville: ${batiment!!.ville}", style = MaterialTheme.typography.bodyMedium)
                // Ajoutez d'autres détails du bâtiment si nécessaires
            }
        }
        else -> Text(text = "Bâtiment non trouvé")
    }
}


