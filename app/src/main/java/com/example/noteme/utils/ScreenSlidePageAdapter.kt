package com.example.noteme.utils

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteme.ui.all.AllFragment
import com.example.noteme.ui.favourite.FavouritesFragment
import com.example.noteme.ui.home.HomeFragment
import com.example.noteme.ui.main.MainActivity

class ScreenSlidePageAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return Constants.FRAGMENTS_NUM
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> AllFragment()
            2 -> FavouritesFragment()
            else -> Fragment()
        }
    }
}