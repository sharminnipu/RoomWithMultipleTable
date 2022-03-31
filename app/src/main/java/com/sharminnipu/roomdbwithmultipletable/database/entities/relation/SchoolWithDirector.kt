package com.sharminnipu.roomdbwithmultipletable.database.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.sharminnipu.roomdbwithmultipletable.database.entities.Director
import com.sharminnipu.roomdbwithmultipletable.database.entities.School

data class SchoolWithDirector (
    @Embedded  val school: School,
    @Relation(
                parentColumn = "schoolName",
                entityColumn = "schoolName"
            )
            val director: Director
)