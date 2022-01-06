package com.example.tote_fifa_2022

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tote_fifa_2022.databinding.ActivityMainBinding
import com.example.tote_fifa_2022.ui.objects.AppSlider
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.utils.color
import com.mikepenz.iconics.utils.size
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    lateinit var mNavController: NavController
    lateinit var mSlider: MaterialDrawerSliderView
    lateinit var mAppSlider: AppSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this
    }

    override fun onStart() {
        super.onStart()

        initFields()
        initFunctions()
    }

    private fun initFunctions() {
        setSupportActionBar(mBinding.toolbar)
        initToolbar()

        mAppSlider.create()

        /*if (AUTH.currentUser != null) {
            mAppSlider.create()

            replaceFragment(MainListFragment(), false)
        } else {
            replaceFragment(EnterPhoneNumberFragment(), false)
        }*/
    }

    private fun initFields() {
        mNavController = Navigation.findNavController(this, R.id.fragmentNavHost)

        mSlider = mBinding.slider
        //mAppSlider = AppSlider(mSlider, this)
        mAppSlider = AppSlider()
    }

    private fun initToolbar() {
        val icon = IconicsDrawable(this, FontAwesome.Icon.faw_bars)
        icon.size = IconicsSize.TOOLBAR_ICON_SIZE
        icon.color = IconicsColor.colorRes(R.color.white)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(icon)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> mSlider.drawerLayout?.openDrawer(mSlider)
        }
        return true
    }
}