package bts.sio.azurimmo.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import bts.sio.azurimmo.model.Batiment

@Composable
fun BatimentCard(batiment: Batiment, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
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
