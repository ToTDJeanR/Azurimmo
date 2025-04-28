package bts.sio.azurimmo.views.batiment

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.api.RetrofitInstance
import bts.sio.azurimmo.model.Batiment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BatimentsConsulter(batimentId: String) {
    val scope = rememberCoroutineScope()
    // Appel API pour récupérer les détails du bâtiment
    LaunchedEffect(Unit) {
        scope.launch {
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Détails du bâtiment") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "Bâtiment ID: $batimentId", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

suspend fun fetchBatimentDetails(id: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val batiment: Batiment = RetrofitInstance.api.getBatimentById(id) //  Appel API
            "Adresse: ${batiment.adresse}\nVille: ${batiment.ville}"
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string() ?: "Réponse vide"
            Log.e("API_ERROR", "Code HTTP: ${e.code()}, Message: ${e.message()}, Réponse: $errorBody")
            "Erreur API : Code ${e.code()} - ${e.message()}"
        } catch (e: IOException) {
            Log.e("API_ERROR", "Problème réseau : ${e.message}")
            "Problème réseau : Vérifie ta connexion Internet"
        } catch (e: Exception) {
            Log.e("API_ERROR", "Erreur inconnue : ${e.localizedMessage}")
            "Erreur inattendue : ${e.localizedMessage}"
        }
    }
}

