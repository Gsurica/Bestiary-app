package com.example.bestiary.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.bestiary.MonsterFormViewModel
import com.example.bestiary.R
import com.example.bestiary.databinding.ActivityMonsterFormBinding

class MonsterFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var _binding: ActivityMonsterFormBinding
    private lateinit var _viewModel: MonsterFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMonsterFormBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _viewModel = ViewModelProvider(this).get(MonsterFormViewModel::class.java)

        setListerners()
        setDefaultRadio()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.register_monster) {
            
        }
    }

    private fun setListerners() {
        _binding.registerMonster.setOnClickListener(this)
    }

    private fun setDefaultRadio() {
        _binding.radioButtonUsed.isChecked = true
    }

}