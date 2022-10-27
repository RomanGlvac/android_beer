package com.example.android.androidbeer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.androidbeer.database.PubDatabase
import com.example.android.androidbeer.repository.PubRepository
import kotlinx.coroutines.launch

class PubListViewModel(application: Application) : AndroidViewModel(application) {

    private val pubRepository = PubRepository(PubDatabase.getDatabase(application))
    val pubHolder = pubRepository.pubs

    fun refreshPubs() {
        viewModelScope.launch {
            try {
                pubRepository.refreshPubs()
            } catch (e: Exception) {
                Log.e("PubListViewModel", e.message.toString())
            }
        }
    }

    fun deletePub(position: Int) {
        pubRepository.deletePub(position)
    }
}