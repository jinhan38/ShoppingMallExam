package com.shoppingmallexam.ui.base

import android.app.ActionBar
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.shoppingmallexam.MainActivity
import com.shoppingmallexam.R
import com.shoppingmallexam.databinding.FragmentParentBinding
import com.shoppingmallexam.ui.Popular.PopularFragment
import com.shoppingmallexam.ui.life.LifeFragment
import com.shoppingmallexam.ui.man.ManFragment
import com.shoppingmallexam.ui.women.WomenFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_parent.*


@AndroidEntryPoint
class ParentFragment : Fragment(R.layout.fragment_parent) {

    companion object {
        private const val TAG = "ParentFragment"
        public const val WHITE: String = "WHITE"
        public const val BLACK: String = "BLACK"
    }

    private val viewModel by viewModels<ParentViewModel>()

    private var _binding: FragmentParentBinding? = null
    private val binding get() = _binding!!

    private lateinit var menu: Menu
    private lateinit var inflater: MenuInflater
    private var menuCurrentColor: String = WHITE
    private var fragmentList: ArrayList<Fragment> = ArrayList<Fragment>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentParentBinding.bind(view)


        
        MainActivity.activity.actionbarTitle("shoppingApp")

        setImageViewPager()
        motionLayoutStateListener()

        tabLayoutSetting()
        setHasOptionsMenu(true)

    }

    private fun tabLayoutSetting() {

        contentsTabLayout.addTab(binding.contentsTabLayout.newTab().setText("인기"))
        contentsTabLayout.addTab(binding.contentsTabLayout.newTab().setText("우먼"))
        contentsTabLayout.addTab(binding.contentsTabLayout.newTab().setText("맨"))
        contentsTabLayout.addTab(binding.contentsTabLayout.newTab().setText("라이프"))

        activity?.supportFragmentManager!!.beginTransaction().replace(R.id.contents_fragment_container, PopularFragment()).commit()

        contentsTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                contentsFragmentChange(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun setImageViewPager() {
        val pagerAdapter = activity?.supportFragmentManager?.let { ScreenSlidePagerAdapter(it) }
        binding.parentTopViewPager.adapter = pagerAdapter
        binding.imageTabLayout.setupWithViewPager(parentTopViewPager)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.app_bar_menu_black, menu); // 앞서 만든 menu를 inflate시킵니다.

//        menuIconColorChange(menu, inflater, WHITE)
        this.menu = menu
        this.inflater = inflater

        val searchItem = menu.findItem(R.id.appBarSearch)
        val searchView = searchItem.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    Toast.makeText(activity, "$query 검색", Toast.LENGTH_SHORT).show()
                    searchView.clearFocus()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }


    private fun motionLayoutStateListener() {

        binding.motionLayoutContainer.setTransitionListener(object :
            MotionLayout.TransitionListener {

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

                when (p3) {

                    in 0.98..1.0 -> {

                        MainActivity.activity.customActionBar.actionBarShowOrHide(true)
//                        menuIconColorChange(menu, inflater, BLACK)

                    }

                    else -> {
                        MainActivity.activity.customActionBar.actionBarShowOrHide(false)
//                        menuIconColorChange(menu, inflater, WHITE)
                    }

                }


            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

        })
    }

    private fun contentsFragmentChange(fragmentPosition: Int) {
        Log.e(TAG, "contentsFragmentChange: $fragmentPosition" )
        
        var fragment: Fragment? = null
        when (fragmentPosition) {
            0 -> fragment = PopularFragment()
            1 -> fragment = ManFragment()
            2 -> fragment = WomenFragment()
            3 -> fragment = LifeFragment()
        }

        activity?.supportFragmentManager!!.beginTransaction().replace(R.id.contents_fragment_container, fragment!!).commit()


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}