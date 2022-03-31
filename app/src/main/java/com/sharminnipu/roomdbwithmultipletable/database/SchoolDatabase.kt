package com.sharminnipu.roomdbwithmultipletable.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sharminnipu.roomdbwithmultipletable.database.entities.Director
import com.sharminnipu.roomdbwithmultipletable.database.entities.School
import com.sharminnipu.roomdbwithmultipletable.database.entities.Student
import com.sharminnipu.roomdbwithmultipletable.database.entities.Subject
import com.sharminnipu.roomdbwithmultipletable.database.entities.relation.StudentSubjectCrossRef
import com.sharminnipu.roomdbwithmultipletable.database.roomDAO.SchoolDao


@Database(entities = [
    School::class,
    Director::class,
    Student::class,
    Subject::class,
    StudentSubjectCrossRef::class

],
    version = 1)
abstract class SchoolDatabase :RoomDatabase(){

    abstract fun schoolDao():SchoolDao

    companion object {
        private const val DATABASE_NAME = "SchoolDatabase"

        @Volatile
        var instance: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase? {
            if (instance == null) {
                synchronized(SchoolDatabase::class.java) {
                    if (instance == null) {
                        instance = Room.databaseBuilder(
                            context, SchoolDatabase::class.java,
                            DATABASE_NAME
                        ).build()
                    }
                }

            }

            return instance

        }
    }
}