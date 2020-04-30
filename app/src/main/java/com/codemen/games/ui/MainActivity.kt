package com.codemen.games.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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
                    R.string.task
                )
            ).hide(homeFragment)
            add(
                R.id.container, listTaskFragment, getString(
                    R.string.home
                )
            )
        }.commit()
        initListeners()

        bottomNavigationView.itemIconTintList = null

        addTask.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.fragment_bottom_sheet_dialog, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(view)
            dialog.show()
        }

    }

    private fun initListeners() {
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment)
                        .commit()
                    activeFragment = homeFragment
                    addTask.hide()
                    true
                }

                R.id.navigation_task -> {
                    fragmentManager.beginTransaction().hide(activeFragment)
                        .show(listTaskFragment).commit()
                    activeFragment = listTaskFragment
                    addTask.show()
                    true
                }

                R.id.navigation_user -> {
                    fragmentManager.beginTransaction().hide(activeFragment).show(userFragment)
                        .commit()
                    activeFragment = userFragment
                    addTask.hide()
                    true
                }

                else -> false
            }
        }
    }



}
