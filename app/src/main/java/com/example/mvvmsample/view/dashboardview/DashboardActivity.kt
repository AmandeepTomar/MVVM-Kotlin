package com.example.mvvmsample.view.dashboardview

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmsample.R
import com.example.mvvmsample.view.dashboardview.fragments.DashBoardFragment
import com.example.mvvmsample.view.dashboardview.fragments.MaterialComponentFragment
import com.example.mvvmsample.view.dashboardview.fragments.SettingsFragment
import com.findmyfans.util.extension.replaceFragment

class DashboardActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val fragment = DashBoardFragment.newInstance("", "")
                supportFragmentManager.replaceFragment(R.id.dashboardContainer, fragment, "Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                val fragment = MaterialComponentFragment.newInstance("", "")
                supportFragmentManager.replaceFragment(R.id.dashboardContainer, fragment, "Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val fragment = SettingsFragment.newInstance("", "")
                supportFragmentManager.replaceFragment(R.id.dashboardContainer, fragment, "Home")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val fragment = MaterialComponentFragment.newInstance("", "")
        supportFragmentManager.replaceFragment(R.id.dashboardContainer, fragment, "Home")

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
