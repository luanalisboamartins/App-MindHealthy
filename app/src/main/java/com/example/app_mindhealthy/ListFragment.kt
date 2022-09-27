package com.example.app_mindhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_mindhealthy.adapter.PostagemAdapter
import com.example.app_mindhealthy.databinding.FragmentListBinding
import com.example.app_mindhealthy.model.PostagemModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val listPostagem = listOf(
            PostagemModel(
                "O Que é trantorno de Ansiedade",
                "O transtorno de ansiedade generalizada (TAG) é um distúrbio caracterizado " +
                        "pela “preocupação excessiva ou expectativa apreensiva”, persistente e de difícil controle, " +
                        "que perdura por seis meses no mínimo.",
                "Link Imagem",
                "Saúde Mental"
            ),
            PostagemModel(
                "Live de autoajuda",
                "Live com dicas e exercicios para ajudar com o estresse\n" + "Link da Live",
                "Link Imagem",
                "Lives"
            ),
            PostagemModel(
                "Grupo de apoio Safe Healthy",
                "Nosso grupo para ajudar pessoas",
                "Link Imagem",
                "Grupos de apoio"
            ),
            PostagemModel(
                "Exercicios para controlar ansiedade",
                "Respirar fundo por 3 segundos e soltar\n" + "Ficar sentado\n" + "Colocar uma música calma",
                "Link Imagem",
                "Controle Ansiedade"
            ),
            PostagemModel(
                "Exercicios para controlar ansiedade",
                "Respirar fundo por 3 segundos e soltar\n" + "Ficar sentado\n" + "Colocar uma música calma",
                "Link Imagem",
                "Controle Ansiedade"
            ),
            PostagemModel(
                "Consultório da Dra. Ana",
                "Estamos com um projeto para atender pessoas de baixa renda, acesse nosso link e veja nossas condições",
                "Link Imagem",
                "Consultas"
            ),
            PostagemModel(
                "Jovens programadores",
                "Grupo de apoio para jovens programadores lidarem com a pressão",
                "Link Imagem",
                "Grupos de apoio"
            )

        )

        val adapter = PostagemAdapter()
        binding.recyclerPostagem.layoutManager = LinearLayoutManager(context)
        binding.recyclerPostagem.adapter = adapter
        binding.recyclerPostagem.setHasFixedSize(true)
        adapter.setList(listPostagem)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_postFragment)
        }

        return binding.root
    }

}