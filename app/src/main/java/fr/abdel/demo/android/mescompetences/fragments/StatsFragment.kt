package fr.abdel.demo.android.mescompetences.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.abdel.demo.android.mescompetences.CompetenceAdapter
import fr.abdel.demo.android.mescompetences.MainActivity
import fr.abdel.demo.android.mescompetences.R
import fr.abdel.demo.android.mescompetences.repositories.CompetenceRepository

class StatsFragment(val context: MainActivity) : Fragment() {

    private val repo = CompetenceRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragement_stats, container, false)

        /* HIGH LVL */
        val recyclerHigherLevel = view.findViewById<RecyclerView>(R.id.stats_best_comp_recycle)
        val compList = repo.competences

        val higherLvlList = compList.sortedBy { it.niveau }
        recyclerHigherLevel.adapter = CompetenceAdapter(listOf(higherLvlList.last()), context)

        /* SUM */
        var sumLevelStats: Int = 0
        compList.forEach {
            sumLevelStats += it.niveau
        }
        val averageLevelStatsView = view.findViewById<TextView>(R.id.average_level_stats)
        averageLevelStatsView.text = sumLevelStats.toString()

        /* LAST UPDATE*/
        val recyclerLastUpdateComp =
            view.findViewById<RecyclerView>(R.id.stats_last_update_comp_recycle)
        val compListSortByDate = compList.sortedBy { it.dateTime.time }
        recyclerLastUpdateComp.adapter = CompetenceAdapter(listOf(compListSortByDate.last()), context)

        return view
    }
}