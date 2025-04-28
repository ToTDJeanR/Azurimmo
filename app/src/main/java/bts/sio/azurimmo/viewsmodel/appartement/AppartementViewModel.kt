package bts.sio.azurimmo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import bts.sio.azurimmo.model.Appartement  // Mise à jour de l'import
import bts.sio.azurimmo.api.RetrofitInstance

class AppartementViewModel : ViewModel() {
    private val _appartements = MutableStateFlow<List<Appartement>>(emptyList())
    val appartements: StateFlow<List<Appartement>> = _appartements

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init { getAppartements() }

    private fun getAppartements() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null  // Réinitialise l'erreur avant l'appel

            try {
                val response = RetrofitInstance.api.getAppartements()
                _appartements.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }
}
