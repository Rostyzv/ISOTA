package com.rosty.isota

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rosty.isota.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        // Configurar el botón de inicio de sesión
        binding.loginButton.setOnClickListener {
            val username1 = binding.usuario.text.toString()

            if (username1.isNotEmpty()) {
                val bundle = Bundle().apply {
                    putString("username", username1)
                }
                findNavController().navigate(R.id.action_loginFragment_to_menuFragment, bundle)

            } else {
                Toast.makeText(requireContext(), "Por favor, introduce un nombre de usuario", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}