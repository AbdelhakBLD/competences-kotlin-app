package fr.abdel.demo.android.mescompetences.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.abdel.demo.android.mescompetences.CompetenceAdapter
import fr.abdel.demo.android.mescompetences.MainActivity
import fr.abdel.demo.android.mescompetences.R
import fr.abdel.demo.android.mescompetences.models.CompetenceModel
import fr.abdel.demo.android.mescompetences.repositories.CompetenceRepository

class HomeFragment(val context: MainActivity): Fragment() {

    private val repo = CompetenceRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragement_home_page, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler_view)

        val compList = repo.competences

        recycler.adapter = CompetenceAdapter(compList, context)

        return view
    }
}