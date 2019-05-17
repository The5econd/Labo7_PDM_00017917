package com.example.labo7_00017917.DataBase.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.labo7_00017917.DataBase.entities.GithubRepo

@Dao
interface GithubRepoDao {

    @Query("SELECT * FROM repos")
    fun getALl() : LiveData<List<GithubRepo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: GithubRepo)

    @Query("DELETE FROM repos")
    fun nukeTable()
}