package com.example.noteme.ui.home

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.noteme.R
import com.example.noteme.databinding.FragmentHomeBinding
import com.example.noteme.databinding.NewNoteDialogBinding
import com.example.noteme.pojo.model.Note
import com.example.noteme.pojo.repository.NotesRepository
import com.example.noteme.ui.home.viewmodel.HomeViewModel
import com.example.noteme.ui.home.viewmodel.HomeViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    // Viewmodel
    private val viewModel: HomeViewModel by lazy {
        val factory = HomeViewModelFactory(NotesRepository.getInstance(requireContext()))
        ViewModelProvider(this, factory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        navController = findNavController()
        // Navigating to fragments
        fragmentsNavigation()

        // Update the UI with the states
        showStates()

        binding.newNoteFab.setOnClickListener {
            addNewNote()
        }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun fragmentsNavigation() {

        binding.apply {
            // To All Fragment
            showAllNotes.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_allFragment)
            }

            // To Favourites Fragment
            showFavNotes.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_favouritesFragment)
            }
        }
    }

    private fun addNewNote() {
        val dialog = Dialog(requireContext(), R.style.PauseDialog)
        val binding = NewNoteDialogBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        // Decorating the dialog
        dialog.setContentView(binding.root)
        // Setting the dimens and the style of the dialog
        val dimens = WindowManager.LayoutParams()
        dimens.copyFrom(dialog.window?.attributes)
        dimens.width = WindowManager.LayoutParams.MATCH_PARENT
        dimens.height = WindowManager.LayoutParams.MATCH_PARENT
        dimens.windowAnimations = R.style.PauseDialogAnimation
        dialog.window?.attributes = dimens

        // Starting the functionality of the dialog
        dialog.show()
        binding.newNoteCancel.setOnClickListener { dialog.dismiss() }

        // This will listen for changes in title
        // Should enable the Add button when title is not empty
        // Otherwise disable it
        binding.newNoteTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.newNoteAdd.isEnabled = p0?.length!! > 1
            }
        })

        // This will listen whenever add button is pressed
        // Should retrieve the note title and content
        binding.newNoteAdd.setOnClickListener {
            val note = Note(
                title = binding.newNoteTitle.text.toString(),
                content = binding.newNoteContent.text.toString()
            )

            viewModel.addNote(note)
            Snackbar.make(this@HomeFragment.binding.root, "Note was added", Snackbar.LENGTH_LONG)
                .show()
            showStates()
            dialog.dismiss()


        }


        binding.newNoteCancel.setOnClickListener {
            dialog.dismiss()
        }

    }

    private fun showStates() {
        viewModel.getNotes().observe(this@HomeFragment) {
            it?.let {
                binding.allNotesCount.text = it.size.toString()
            }
        }


    }


}