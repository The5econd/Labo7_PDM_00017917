package com.example.labo7_00017917

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo7_00017917.DataBase.entities.GithubRepo
import com.example.labo7_00017917.DataBase.viewmodels.GithubRepoViewModel
import com.example.labo7_00017917.adapter.ReposAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ReposAdapter
    lateinit var viewModel : GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    fun bind (){
        adapter = ReposAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        rv_haha.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_add.setOnClickListener {
            viewModel.insert(GithubRepo(et_repo_name.text.toString()))
        }
    }
}
