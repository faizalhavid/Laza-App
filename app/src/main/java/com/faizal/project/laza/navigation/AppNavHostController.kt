package com.faizal.project.laza.navigation

import androidx.fragment.app.Fragment
import android.content.Context
import androidx.navigation.NavHostController

class AppNavHostController(context: Context, navHostFragment: Fragment):NavHostController(context) {
    fun navigateToCheckoutStep(isPaymentCompleted:Boolean){
        if(isPaymentCompleted){
            navigate("home")
        }
    }

    fun popBackStackToHome(){
        popBackStack("home" , false)
    }
}