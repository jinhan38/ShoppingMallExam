package com.shoppingmallexam.ui.base

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

@Suppress("DEPRECATION")
class ContentViewPagerAdapter(fm: FragmentManager, private val fragment : MutableList<Fragment> ) : FragmentStatePagerAdapter(fm) {

//    private lateinit var fragmentList: ArrayList<Fragment> = ArrayList<Fragment>()


    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        
        return fragment[position]
    }

}