package com.example.app_mindhealthy.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app_mindhealthy.MainViewModel
import com.example.app_mindhealthy.PostFragment
import com.example.app_mindhealthy.databinding.CardLayoutBinding
import com.example.app_mindhealthy.model.Postagem


class PostagemAdapter(
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
    val context: Context

): RecyclerView.Adapter<PostagemAdapter.PostagemViewHolder>(){

    private var listPostagem = emptyList<Postagem>()

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
        holder.binding.textTemas.text = postagem.temas.tema

        Glide
            .with(context)
            .load(postagem.imagem)
            .placeholder(android.R.drawable.ic_menu_report_image)
            .into(holder.binding.imageView)

        holder.binding.buttonEditar.setOnClickListener {
            taskClickListener.onTaskClickListener(postagem)
        }


        mainViewModel.updatePostagem(postagem)

        holder.binding.buttonDeletar.setOnClickListener{
            showAlertDialog(postagem.id)
        }


    }

    override fun getItemCount(): Int {
        return listPostagem.size

    }

    fun setList(list: List<Postagem>){
        listPostagem = list.sortedByDescending { it.id }
        notifyDataSetChanged()
    }

    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Postagem")
            .setMessage("Deseja Excluir Postagem?")
            .setPositiveButton("Sim"){
                    _,_ -> mainViewModel.deletePostagem(id)
            }

            .setNegativeButton("Não"){
                    _,_ ->
            }.show()
    }

}
