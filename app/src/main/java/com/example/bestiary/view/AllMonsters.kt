package com.example.bestiary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.bestiary.databinding.FragmentAllMonstersBinding
import com.example.bestiary.viewModel.AllMonsterViewModel

class AllMonsters : Fragment() {

    private var _binding: FragmentAllMonstersBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: AllMonsterViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(AllMonsterViewModel::class.java)

        _binding = FragmentAllMonstersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.getAll()

        observe()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.allMonsters.observe(viewLifecycleOwner) {
            val s = ""
        }
    }
}