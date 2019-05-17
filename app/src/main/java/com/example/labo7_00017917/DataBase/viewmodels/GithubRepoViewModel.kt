package com.example.labo7_00017917.DataBase.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_00017917.DataBase.RoomDB
import com.example.labo7_00017917.DataBase.entities.GithubRepo
import com.example.labo7_00017917.DataBase.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class GithubRepoViewModel (app : Application) : AndroidViewModel(app){

    private val repository : GithubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDao()
        repository = GithubRepoRepository(repoDao)
    }

    fun getAll() : LiveData<List<GithubRepo>> = repository.getAll()

    fun insert(repo : GithubRepo) = viewModelScope.launch(Dispatchers.IO) {repository.insert(repo)}

    fun nuke() = repository.nuke()

}