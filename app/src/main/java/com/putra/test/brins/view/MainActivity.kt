package com.putra.test.brins.view

import android.R
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.putra.test.brins.databinding.ActivityMainBinding
import com.putra.test.brins.view.fragment.AnagramFragment
import com.putra.test.brins.view.fragment.FibonacciFragment
import com.putra.test.brins.view.fragment.PermutationFragment


class MainActivity : AppCompatActivity(),  BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when (item.itemId){
            com.putra.test.brins.R.id.fibonacciFragment -> {
                fragment = FibonacciFragment()
            }
            com.putra.test.brins.R.id.anagramFragment -> {
                fragment = AnagramFragment()
            }
            com.putra.test.brins.R.id.permutationFragment -> {
                fragment = PermutationFragment()
            }
        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(com.putra.test.brins.R.id.fragmentContainerView, fragment)
                .commit()
            return true
        }
        return false
    }

}