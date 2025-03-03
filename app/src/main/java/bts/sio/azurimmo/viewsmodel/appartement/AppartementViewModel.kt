package bts.sio.azurimmo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import bts.sio.azurimmo.model.Appartement  // Mise à jour de l'import

class AppartementViewModel : ViewModel() {
    private val _appartements = MutableStateFlow<List<Appartement>>(emptyList())
    val appartements: StateFlow<List<Appartement>> = _appartements

    init {
        getAppartements()
    }

    private fun getAppartements() {
        viewModelScope.launch {
            _appartements.value = listOf(
                Appartement(1, 18, "20x36", 2,"Un appartement chic"),
                Appartement(2, 19, "20x36", 4,"Un appartement Bien ordonné"),
                Appartement(3, 25, "36x48", 5,"Un appartement Spatieux")
            )
        }
    }
}
