package com.shoppingmallexam.ui.base

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shoppingmallexam.ui.base.slideViewPager.TopViewPager_1
import com.shoppingmallexam.ui.base.slideViewPager.TopViewPager_2
import com.shoppingmallexam.ui.base.slideViewPager.TopViewPager_3
import com.shoppingmallexam.ui.base.slideViewPager.TopViewPager_4

class ScreenSlidePagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TopViewPager_1()
            1 -> TopViewPager_2()
            2 -> TopViewPager_3()
            3 -> TopViewPager_4()

            else -> TopViewPager_1()
        }

    }
}