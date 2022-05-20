package fr.abdel.demo.android.mescompetences

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.abdel.demo.android.mescompetences.models.CompetenceModel
import fr.abdel.demo.android.mescompetences.popups.CompetenceDetailPopup

class CompetenceAdapter(
    val liste: List<CompetenceModel>,
    val context: Context
    ): RecyclerView.Adapter<CompetenceAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val compNameView = view.findViewById<TextView>(R.id.comp_name)
        val compLvlView = view.findViewById<TextView>(R.id.comp_lvl)
        val recyclerTagView = view.findViewById<RecyclerView>(R.id.tag_recycler_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_competence, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comp = liste[position]
        holder.compNameView.text = comp.name
        val niveau = "niveau ${comp.niveau}"
        holder.compLvlView.text = niveau
        holder.recyclerTagView.adapter = TagsAdapter(comp.tags)
        holder.itemView.setOnClickListener{
            CompetenceDetailPopup(this.context,comp).show()
        }
    }

    override fun getItemCount(): Int = liste.size
}