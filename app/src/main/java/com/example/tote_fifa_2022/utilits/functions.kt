package com.example.tote_fifa_2022.utilits

import android.widget.Toast
import androidx.fragment.app.Fragment

/*fun replaceFragment(fragment: Fragment, addStack: Boolean = true) {
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
}*/

fun showToast(message: String) {
    Toast.makeText(APP_ACTIVITY, message, Toast.LENGTH_LONG).show()
}

