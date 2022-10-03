package com.example.app_mindhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.app_mindhealthy.databinding.FragmentListBinding
import com.example.app_mindhealthy.databinding.FragmentPostBinding
import com.example.app_mindhealthy.model.PostagemModel

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPostBinding.inflate(layoutInflater, container, false)

        binding.buttonPublicar.setOnClickListener {
            inserirBanco()
        }
        return binding.root
    }

    fun validarCampos (titulo: String, postagem: String, imagem: String): Boolean {
        return!(
                (titulo == "" ||  titulo.length<3 || titulo.length>255) ||
        (postagem == "" || postagem.length<3 || postagem.length>255) ||
        (imagem == "" || imagem.length<3 || imagem.length>255)
        )
    }
    fun inserirBanco (){
        val titulo = binding.editTextTitulo.text.toString()
        val postagem = binding.editTextPost.text.toString()
        val imagem = binding.editTextLinkImage.text.toString()

        if (validarCampos(titulo, postagem, imagem)){
            val postagem = PostagemModel (titulo, postagem, imagem, tema = "text")
            Toast.makeText(context, "Tarefa criada" , Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_postFragment_to_listFragment)
        }else {
            Toast.makeText(context, "Verifique os campos" , Toast.LENGTH_SHORT).show()
        }
    }

}
