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
import com.shoppingmallexam.data.CustomActionBar
import com.shoppingmallexam.ui.base.ParentFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    companion object{
        lateinit var activity: MainActivity
    }
    private lateinit var navController: NavController
    public lateinit var customActionBar : CustomActionBar
//    private lateinit var actionBar: ActionBar

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this




        customActionBar = supportActionBar?.let { CustomActionBar(this, it) }!!
        customActionBar.setActionBar()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        navController = navHostFragment.findNavController()

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    fun actionbarTitle(title : String){

        customActionBar.actionbarTitle(title)
//        supportActionBar?.title = title
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}