package com.example.android.androidbeer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.androidbeer.database.PubDatabase
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.network.Api
import com.example.android.androidbeer.network.Request
import com.example.android.androidbeer.repository.PubRepository
import kotlinx.coroutines.launch

class PubListViewModel(application: Application) : AndroidViewModel(application) {

    private val pubRepository = PubRepository(PubDatabase.getDatabase(application))

    init {
        getPubs()
    }

    fun getPubs(){
        viewModelScope.launch {
            try{
                pubRepository.refreshPubs()
            } catch (e: Exception){
                Log.e("PubListViewModel", e.message.toString())
            }
        }
    }
}