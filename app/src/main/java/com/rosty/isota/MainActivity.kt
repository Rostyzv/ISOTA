package com.rosty.isota

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rosty.isota.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val primer = ItemListFragment()
    val segun = FavItemListFragment()
    val terce = UserInfoFragment()
    val home = MenuFragment()
    var username: String? = null

    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val navFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view2) as NavHostFragment
        val navController = navFragment.navController
        NavigationUI.setupActionBarWithNavController(this,navController)
        // Ocultar el BottomNavigationView cuando se muestre el LoginFragment
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.loginFragment || destination.id == R.id.mainFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
        setContentView(view)

        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.primer-> {
                    loadFragment(primer)
                    true
                }
                R.id.segun -> {
                    loadFragment(segun)
                    true
                }
                R.id.terce -> {
                    loadFragment(terce)
                    true
                }

                else -> false
            }
        }
    }
    fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view2, fragment)
        transaction.commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment_container_view2)
        return navController.navigateUp()
    }
}