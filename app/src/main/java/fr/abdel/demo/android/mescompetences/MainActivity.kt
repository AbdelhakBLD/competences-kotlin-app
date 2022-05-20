package fr.abdel.demo.android.mescompetences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.abdel.demo.android.mescompetences.fragments.HomeFragment
import fr.abdel.demo.android.mescompetences.fragments.NewCompetenceFragment
import fr.abdel.demo.android.mescompetences.fragments.StatsFragment
import fr.abdel.demo.android.mescompetences.repositories.CompetenceRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navMenu = findViewById<BottomNavigationView>(R.id.nav_menu)

        loadFragment(HomeFragment(this), R.string.home_page_title)
        navMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_page -> {
                    loadFragment(HomeFragment(this), R.string.home_page_title)
                    return@setOnItemSelectedListener true
                }
                R.id.stats -> {
                    loadFragment(StatsFragment(this), R.string.stats_page)
                    return@setOnItemSelectedListener true
                }
                R.id.new_competence -> {
                    loadFragment(NewCompetenceFragment(this), R.string.new_comp_page_title)
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }

    }

    fun loadFragment(fragment: Fragment, titleId: Int) {
        val pagetitleView = findViewById<TextView>(R.id.page_title)
        pagetitleView.text = resources.getString(titleId)
        CompetenceRepository.updateAll {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}