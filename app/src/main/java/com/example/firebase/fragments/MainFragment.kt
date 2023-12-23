package com.example.firebase.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firebase.R
import com.example.firebase.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        btnRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, RegisterFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        btnLogin.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, LoginFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}