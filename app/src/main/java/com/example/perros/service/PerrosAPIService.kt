package com.example.perros.service

import com.example.perros.response.PerroResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PerrosAPIService {
    @GET
    fun getPerrosPorRaza(@Url url: String):
            Call<PerroResponse>
}