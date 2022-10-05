package com.example.app_mindhealthy.api

import com.example.app_mindhealthy.model.Postagem
import com.example.app_mindhealthy.model.Temas
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("temas")
    suspend fun listTemas(): Response<List<Temas>>

    @POST("postagem")
    suspend fun addPostagem (
        @Body postagem: Postagem
    ):Response<Postagem>

    @GET("postagem")
    suspend fun  listPostagem(): Response<List<Postagem>>
}