package com.shoppingmallexam.ui.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ContentViewPagerAdapter(fm: FragmentManager, private val fragment : List<Fragment> ) : FragmentPagerAdapter(fm) {



    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment.get(position)
    }

}