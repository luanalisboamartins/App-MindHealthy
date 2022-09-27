package com.example.app_mindhealthy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_mindhealthy.databinding.CardLayoutBinding
import com.example.app_mindhealthy.model.PostagemModel

class PostagemAdapter:RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder>(){

    private var listPostagem = emptyList<PostagemModel>()

    class PostagemViewHolder(val binding: CardLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostagemViewHolder {
        return PostagemViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,false
        ))
    }

    override fun onBindViewHolder(holder: PostagemViewHolder, position: Int) {
       val postagem = listPostagem[position]

        holder.binding.textTituloPost.text = postagem.titulo
        holder.binding.textDescricao.text = postagem.descricao
        holder.binding.textLinkImagem.text = postagem.imagem
        holder.binding.textTemas.text = postagem.tema

    }

    override fun getItemCount(): Int {
        return listPostagem.size

    }

    fun setList(list: List<PostagemModel>){
        listPostagem = list
        notifyDataSetChanged()
    }

}
