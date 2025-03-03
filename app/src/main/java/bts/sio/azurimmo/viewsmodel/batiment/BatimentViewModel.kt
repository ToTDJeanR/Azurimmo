package bts.sio.azurimmo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import bts.sio.azurimmo.model.Batiment  // Mise à jour de l'import

class BatimentViewModel : ViewModel() {
    private val _batiments = MutableStateFlow<List<Batiment>>(emptyList())
    val batiments: StateFlow<List<Batiment>> = _batiments

    init {
        getBatiments()
    }

    private fun getBatiments() {
        viewModelScope.launch {
            _batiments.value = listOf(
                Batiment(1, "123 Rue Principale", "Nice"),
                Batiment(2, "456 Avenue des Champs", "Marseille"),
                Batiment(3, "789 Boulevard Haussmann", "Marseille")
            )
        }
    }
}
