package com.sharminnipu.roomdbwithmultipletable.database.roomDAO

import androidx.room.*
import com.sharminnipu.roomdbwithmultipletable.database.entities.*
import com.sharminnipu.roomdbwithmultipletable.database.entities.relation.*

@Dao
interface SchoolDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
   @Query("SELECT * FROM school WHERE schoolName= :schoolName")
   suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String) :List<SchoolWithDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName= :schoolName")
    suspend fun getSchoolAndStudentWithSchoolName(schoolName:String) :List<SchoolAndStudent>


    @Transaction
    @Query("SELECT * FROM student WHERE studentName= :studentName")
    suspend fun getSubjectOfStudent(studentName:String) :List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName= :subjectName")
    suspend fun getStudentOfSubject(subjectName:String) :List<SubjectWithStudents>


}