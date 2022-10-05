package com.example.app_mindhealthy.model

    data class Postagem (
        var id: Long,
        var titulo: String,
        var descricao: String,
        var imagem: String,
        var temas: Temas
        ){
}