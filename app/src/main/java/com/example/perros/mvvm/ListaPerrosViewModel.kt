package com.example.perros.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.perros.patterns.RetroFitSingleton
import com.example.perros.response.PerroResponse
import com.example.perros.service.PerrosAPIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaPerrosViewModel: ViewModel() {
    var liveData : MutableLiveData<List<String>>
    init{
        liveData = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<List<String>>{
        return liveData
    }
    fun perroAPICall(raza:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroFitSingleton.getRetroFit().create(PerrosAPIService::class.java)
                .getPerrosPorRaza("$raza/images")
            call.enqueue(object : Callback<PerroResponse> {
                override fun onResponse(call: Call<PerroResponse>, response: Response<PerroResponse>) {
                    liveData.postValue(response.body()?.imagenes?: emptyList())
                }

                override fun onFailure(call: Call<PerroResponse>, t: Throwable) {
                    liveData.postValue(emptyList())
                }

            })
        }
    }
}