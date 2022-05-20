package fr.abdel.demo.android.mescompetences

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.abdel.demo.android.mescompetences.models.TagsModel

class TagsAdapter(
    val liste: List<String>
    ): RecyclerView.Adapter<TagsAdapter.TagViewHolder>() {

    class TagViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tagName = view.findViewById<TextView>(R.id.tag_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.tag_competence, parent, false)
        return TagViewHolder(view)
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        val tag = liste[position]
        holder.tagName.text = liste[position]
    }

    override fun getItemCount(): Int = liste.size

}