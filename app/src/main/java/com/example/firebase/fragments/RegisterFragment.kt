package com.example.firebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firebase.R
import com.example.firebase.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() = with(binding){
        firebaseAuth = FirebaseAuth.getInstance()
        btnRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if(email.isEmpty())
                Toast.makeText(context, "Email is empty", Toast.LENGTH_LONG).show()
            else if(password.isEmpty())
                Toast.makeText(context, "Password is empty", Toast.LENGTH_LONG).show()
            else if(password.length < 6)
                Toast.makeText(context, "Password is too small", Toast.LENGTH_LONG).show()
            else {
                registerUser(email, password)
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}