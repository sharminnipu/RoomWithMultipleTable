package com.sharminnipu.roomdbwithmultipletable.database.entities.relation

import androidx.room.Entity

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(
    val studentName:String,
    val subjectName:String


)
