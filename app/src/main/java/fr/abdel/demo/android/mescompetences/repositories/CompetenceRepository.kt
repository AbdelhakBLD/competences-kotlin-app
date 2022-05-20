package fr.abdel.demo.android.mescompetences.repositories

import android.util.Log
import androidx.appcompat.widget.AppCompatTextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.abdel.demo.android.mescompetences.models.CompetenceModel
import java.time.LocalDateTime
import java.util.*
import javax.security.auth.callback.Callback

object CompetenceRepository {

    val dbRef = FirebaseDatabase.getInstance().getReference("competences")

    val competences = mutableListOf<CompetenceModel>()

    fun updateAll(callback: ()->Unit) {
        dbRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                competences.clear()
                snapshot.children.forEach {
                    val comp = it.getValue(CompetenceModel::class.java)
                    if (comp!=null) competences.add(comp)
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("CompetenceRepository", error.message)
            }

        })
    }

    fun insert(competence: CompetenceModel): Unit {
        competence.dateTime = Date()
        dbRef.child(competence.id).setValue(competence)
    }

    fun remove(competence: CompetenceModel): Unit {
        dbRef.child(competence.id).removeValue()
    }
}