package com.shoppingmallexam.ui.base

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter


class IndicatorViewPagerAdapter(
    private val drawableList: List<Drawable>
) : PagerAdapter() {

    private var inflater: LayoutInflater? = null
    private val context: Context? = null


//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
////        val v: View = inflater.inflate(context..R.layout.ac, container, false)
//
//    }

    override fun getCount(): Int {
        return drawableList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object` as LinearLayout
    }
}