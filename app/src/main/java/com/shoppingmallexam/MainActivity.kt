package com.shoppingmallexam

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.shoppingmallexam.ui.base.ParentFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    companion object{
        lateinit var activity: MainActivity
    }
    private lateinit var navController: NavController
//    private lateinit var actionBar: ActionBar

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this

        supportActionBar?.setShowHideAnimationEnabled(true)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    fun actionBarTextColorChange(strColor: String) {

        var color : Int = 0

        color = when (strColor) {
            ParentFragment.WHITE -> activity.resources.getColor(R.color.white)
            else -> activity.resources.getColor(R.color.black)
        }


        val text: Spannable = SpannableString(supportActionBar?.title)
        text.setSpan(
            ForegroundColorSpan(color),
            0,
            text.length,
            Spannable.SPAN_INCLUSIVE_INCLUSIVE
        )
        supportActionBar?.title = text
    }

    fun actionBarShowOrHide(isShowing: Boolean) {
        when (isShowing) {
            true -> supportActionBar?.show()
            else -> supportActionBar?.hide()

        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}