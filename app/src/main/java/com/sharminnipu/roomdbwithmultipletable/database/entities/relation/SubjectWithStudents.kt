package com.sharminnipu.roomdbwithmultipletable.database.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.sharminnipu.roomdbwithmultipletable.database.entities.Student
import com.sharminnipu.roomdbwithmultipletable.database.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)
