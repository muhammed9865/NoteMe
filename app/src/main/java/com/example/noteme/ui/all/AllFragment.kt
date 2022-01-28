package com.example.noteme.ui.all

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteme.R
import com.example.noteme.databinding.FragmentAllBinding
import com.example.noteme.pojo.model.Note
import com.example.noteme.pojo.repository.NotesRepository
import com.example.noteme.ui.all.adapter.AllFragmentAdapter
import com.example.noteme.ui.all.adapter.`interface`.NoteUtilties
import com.example.noteme.ui.all.viewmodel.AllFragmentViewModel
import com.example.noteme.ui.all.viewmodel.AllVMFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllFragment : Fragment() {
    private val viewModel: AllFragmentViewModel by lazy {
        val factory = AllVMFactory(NotesRepository.getInstance(requireContext()))
        ViewModelProvider(this, factory)[AllFragmentViewModel::class.java]
    }
    private val allAdapter: AllFragmentAdapter by lazy { AllFragmentAdapter() }
    private lateinit var binding: FragmentAllBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all, null, false)

        updateUI()
        setUpRecyclerView()


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun updateUI() {
        viewModel.getNotes().observe(this) {
            allAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        // Setting up the Note utilities
        allAdapter.setNoteUtilties(object : NoteUtilties {
            override fun deleteNote(note_id: Int) {

                viewModel.deleteNote(note_id)
                allAdapter.notifyDataSetChanged()
                updateUI()

            }

            override fun editNote(note: Note) {

                    viewModel.updateNote(note)
                    allAdapter.notifyDataSetChanged()
                    updateUI()
                }

        })

        binding.allNotesRv.apply {
            adapter = allAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }


}