package com.sharminnipu.roomdbwithmultipletable.database.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.sharminnipu.roomdbwithmultipletable.database.entities.School
import com.sharminnipu.roomdbwithmultipletable.database.entities.Student

data class SchoolAndStudent(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName",
    )
    val students:List<Student>
)
