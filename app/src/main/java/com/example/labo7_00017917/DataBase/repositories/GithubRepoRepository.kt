package com.example.labo7_00017917.DataBase.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_00017917.DataBase.daos.GithubRepoDao
import com.example.labo7_00017917.DataBase.entities.GithubRepo

class GithubRepoRepository(private val repoDAO : GithubRepoDao){

    fun getAll() : LiveData<List<GithubRepo>> = repoDAO.getALl()

    fun nuke() = repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDAO.insert(repo)
    }
}