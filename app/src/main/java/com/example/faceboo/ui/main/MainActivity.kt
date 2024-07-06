package com.example.faceboo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.faceboo.databinding.ActivityMainBinding
import com.example.faceboo.pojo.PostModel

class MainActivity : AppCompatActivity() {

    lateinit var postViewModel : PostViewModel

    lateinit var binding : ActivityMainBinding
    lateinit var myAdapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        // View Binding

         binding  = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setAdapter()
        postViewModel = ViewModelProviders.of(this)[PostViewModel::class.java]

        postViewModel.getPosts()
        postViewModel.postMutableLiveDat.observe(this ,object :  Observer<List<PostModel>>{
            override fun onChanged(value: List<PostModel>) {
                val list  = value as ArrayList<PostModel>
               myAdapter.setList(list)
            }

        })


    }

    fun setAdapter(){


        binding.recycler.layoutManager = LinearLayoutManager(this)
        myAdapter =MyAdapter()

       binding.recycler.adapter = myAdapter

    }
}