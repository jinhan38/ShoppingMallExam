package com.shoppingmallexam.data

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import androidx.appcompat.app.ActionBar
import com.shoppingmallexam.R

class CustomActionBar(private val activity : Activity, private val actionBar: ActionBar)  {


    @SuppressLint("RestrictedApi")
    fun setActionBar(){
        val view : View = activity.layoutInflater.inflate(R.layout.activity_custom_action_bar, null)
        actionBar.hide()
        actionBar.setShowHideAnimationEnabled(true)
        actionBar.customView = view
    }

    fun actionbarTitle(title : String){
        actionBar.title = title
    }

    fun actionBarShowOrHide(isShowing: Boolean) {
        when (isShowing) {
            true -> actionBar.show()
            else -> actionBar.hide()
        }

    }
    

}