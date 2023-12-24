package com.example.firebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firebase.R
import com.example.firebase.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() = with(binding) {
        firebaseAuth = FirebaseAuth.getInstance()
        btnRegister.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, RegisterFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
        btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_LONG).show()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.placeHolder, MainFragment.newInstance())
                        .commit()
                } else {
                    Toast.makeText(context, "Wrong password or email!", Toast.LENGTH_LONG).show()
                }
            }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()
    }
}