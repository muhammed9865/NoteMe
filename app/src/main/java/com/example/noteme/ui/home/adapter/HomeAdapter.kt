package com.example.noteme.ui.home.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.noteme.pojo.model.List

class HomeAdapter :ListAdapter<List, HomeViewHolder>(HomeDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}