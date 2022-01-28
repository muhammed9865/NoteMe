package com.example.noteme.ui.all.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.noteme.pojo.repository.NotesRepository

@Suppress("UNCHECKED_CAST")
class AllVMFactory(private val repository: NotesRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return AllFragmentViewModel(repository) as T
    }
}


