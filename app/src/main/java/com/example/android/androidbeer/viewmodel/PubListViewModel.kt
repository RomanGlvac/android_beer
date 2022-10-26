package com.example.android.androidbeer.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.androidbeer.models.PubHolder
import com.example.android.androidbeer.network.Api
import com.example.android.androidbeer.network.Request
import kotlinx.coroutines.launch

class PubListViewModel : ViewModel() {
    private val _pubHolder = MutableLiveData<PubHolder?>()
    val pubHolder: LiveData<PubHolder?> = _pubHolder

    private val _size = MutableLiveData("None")
    val size : LiveData<String> = _size

    init {
        getPubs()
    }

    fun getPubs(){
        viewModelScope.launch {
            try{
                val data = Api.retrofitService.getPubs(
                    Request(collection = "bars",
                    database = "mobvapp",
                    dataSource = "Cluster0"))
                _pubHolder.value = data
                _size.value = data.pubs.size.toString() + " elements loaded"
            } catch (e: Exception){
                Log.e("PubListViewModel", e.message.toString())
            }
        }
    }
}