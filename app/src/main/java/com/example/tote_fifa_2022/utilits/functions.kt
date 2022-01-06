package com.example.tote_fifa_2022.utilits

import androidx.fragment.app.Fragment
import com.example.tote_fifa_2022.R

fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
    /* Функция для установки фрагмента */
    if (addStack) {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentNavHost, fragment)
            .commit()
    } else {
        APP_ACTIVITY.supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentNavHost, fragment)
            .commit()
    }
}
