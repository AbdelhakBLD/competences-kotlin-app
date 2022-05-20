package fr.abdel.demo.android.mescompetences.models

import java.time.LocalDateTime
import java.util.*

class CompetenceModel(
    val id: String = UUID.randomUUID().toString(),
    val name: String = "UNKNOWN",
    var _niveau: Int = 0,
    val tags: List<String> = listOf(),
    val description: String = "UNKNOWN",
    var dateTime: Date = Date()
) {
    var niveau: Int
        get() = _niveau
        set(newNiveau) {
            if (newNiveau < 0) _niveau = 0
            else if (newNiveau > 20) _niveau = 20
            else _niveau = newNiveau
        }
}
