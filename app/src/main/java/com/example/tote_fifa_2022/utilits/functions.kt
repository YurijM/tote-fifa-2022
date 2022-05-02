package com.example.tote_fifa_2022.utilits

import android.widget.Toast
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.ui.objects.AppSlider
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.utils.color
import com.mikepenz.iconics.utils.size

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

fun initSlider() {
    if (AppPreferences.getAuthUser()) {
        initToolbar()

        //mSlider = mBinding.slider
        //mAppSlider = AppSlider(mSlider, this)

        val appSlider = AppSlider()
        appSlider.create()

        APP_ACTIVITY.mNavController.navigate(R.id.gamblersFragment)

    } else {
        APP_ACTIVITY.mNavController.navigate(R.id.loginFragment)
    }
}

private fun initToolbar() {
    val icon = IconicsDrawable(APP_ACTIVITY, FontAwesome.Icon.faw_bars)
    icon.size = IconicsSize.TOOLBAR_ICON_SIZE
    icon.color = IconicsColor.colorRes(R.color.white)

    APP_ACTIVITY.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    APP_ACTIVITY.supportActionBar?.setHomeAsUpIndicator(icon)
}

