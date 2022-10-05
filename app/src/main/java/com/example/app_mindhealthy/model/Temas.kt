package com.example.app_mindhealthy.model

data class Temas (
    var id: Long,
    var tema: String?,
    var postagem: List<Postagem>?

){
    override fun toString(): String {
        return tema!!
    }
}