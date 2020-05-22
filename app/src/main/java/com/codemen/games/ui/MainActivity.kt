package com.codemen.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.codemen.games.R
import com.codemen.games.databinding.ActivityMainBinding
import com.codemen.games.ui.fragment.HomeFragment
import com.codemen.games.ui.fragment.ListTaskFragment
import com.codemen.games.ui.fragment.UserFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val listTaskFragment = ListTaskFragment()
    private val homeFragment = HomeFragment()
    private val userFragment = UserFragment()
    private val fragmentManager = supportFragmentManager
    private var activeFragment: Fragment = listTaskFragment




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        fragmentManager.beginTransaction().apply {
            add(
                R.id.container, userFragment, getString(
                    R.string.user
                )
            ).hide(userFragment)
            add(
                R.id.container, homeFragment, getString(
                    R.string.home
                )
            ).hide(homeFragment)
            add(
                R.id.container, listTaskFragment, getString(
                    R.string.task
                )
            )
        }.commit()
        initListeners()

        bottomNavigationView.itemIconTintList = null

    }

    private fun initListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment)
                        .commit()
                    activeFragment = homeFragment

                    true
                }

                R.id.navigation_task -> {
                    fragmentManager.beginTransaction().hide(activeFragment)
                        .show(listTaskFragment).commit()
                    activeFragment = listTaskFragment


                    true
                }

                R.id.navigation_user -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(userFragment)
                        .commit()
                    activeFragment = userFragment

                    true
                }

                else -> false
            }
        }
    }



}
