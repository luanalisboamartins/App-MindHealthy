package com.example.app_mindhealthy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app_mindhealthy.databinding.FragmentListBinding
import com.example.app_mindhealthy.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentPostBinding.inflate(layoutInflater, container, false)

        binding.buttonPublicar.setOnClickListener {
            findNavController().navigate(R.id.action_postFragment_to_listFragment)
        }

        return binding.root

    }

}