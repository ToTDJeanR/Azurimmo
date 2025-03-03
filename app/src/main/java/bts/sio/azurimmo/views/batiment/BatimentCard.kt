package bts.sio.azurimmo.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import bts.sio.azurimmo.model.Batiment  // Mise à jour de l'import

@Composable
fun BatimentCard(batiment: Batiment) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = batiment.adresse, style = MaterialTheme.typography.bodyLarge)
            Text(text = batiment.ville, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
