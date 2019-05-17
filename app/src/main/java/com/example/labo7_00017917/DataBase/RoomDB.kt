package com.example.labo7_00017917.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.labo7_00017917.DataBase.daos.GithubRepoDao
import com.example.labo7_00017917.DataBase.entities.GithubRepo

@Database(entities = [GithubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase(){

    abstract fun repoDao() : GithubRepoDao

    companion object {
        //para notificar a todos los hilos
        @Volatile
        private var INSTANCE : RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java, "Repo_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}