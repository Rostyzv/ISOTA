package com.rosty.isota

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rosty.isota.databinding.FragmentMenuBinding



class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("username") ?: "Usuario desconocido"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root

        // Aquí puedes utilizar el valor de 'username' para configurar el fragmento de destino
        Toast.makeText(requireContext(), "Bienvenido, $username", Toast.LENGTH_SHORT).show()

        // Configurar el texto del TextView con el nombre de usuario
        binding.usernameTextView.text = "Usuario: $username"

        // Configurar el botón de créditos
        binding.creditsButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_creditFragment)
        }

        // Configurar el botón de salir
        binding.logoutButton.setOnClickListener {
            findNavController().popBackStack(R.id.loginFragment, false)
        }

        binding.lista.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_itemListFragment)
        }

        binding.listafav.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_favItemListFragment)
        }

        binding.usu.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_userInfoFragment)
        }
        binding.usu.setOnClickListener {
            val bundle = Bundle().apply {
                putString("username", username)
            }
            findNavController().navigate(R.id.userInfoFragment, bundle)
        }


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {

                }
            }
        fun fromBundle(bundle: Bundle): MenuFragment {
            val fragment = MenuFragment()
            fragment.arguments = bundle
            return fragment
        }

    }

}