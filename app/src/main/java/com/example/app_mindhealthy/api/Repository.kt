package com.example.app_mindhealthy.api

import com.example.app_mindhealthy.model.Postagem
import com.example.app_mindhealthy.model.Temas
import retrofit2.Response

class Repository {
        suspend fun listTemas(): Response<List<Temas>> {
            return RetrofitInstance.api.listTemas()
        }
        suspend fun addPostagem(postagem: Postagem): Response<Postagem> {
            return RetrofitInstance.api.addPostagem(postagem)
        }

        suspend fun listPostagem(): Response<List<Postagem>> {
            return RetrofitInstance.api.listPostagem()
        }


    }
