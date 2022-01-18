package com.example.tote_fifa_2022

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tote_fifa_2022.databinding.ActivityMainBinding
import com.example.tote_fifa_2022.ui.objects.AppSlider
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY
import com.example.tote_fifa_2022.utilits.AppPreferences
import com.example.tote_fifa_2022.utilits.START_YEAR
import com.mikepenz.iconics.IconicsColor
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.IconicsSize
import com.mikepenz.iconics.typeface.library.fontawesome.FontAwesome
import com.mikepenz.iconics.utils.color
import com.mikepenz.iconics.utils.size
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    lateinit var mNavController: NavController
    lateinit var mSlider: MaterialDrawerSliderView
    lateinit var mAppSlider: AppSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this

        AppPreferences.getPreference(this)
        AppPreferences.setAuthUser(false)

        //initFields()
        //initFunctions()

        initialization()

        // Write a message to the database
        /*val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.push().setValue("Hello, World!")*/
    }

    private fun setCopyright() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        var copyright = mBinding.copyrightYear

        if (year != START_YEAR) {
            val strYear = "$START_YEAR-$year"
            copyright.text = strYear
        } else {
            copyright.text = START_YEAR.toString()
        }
    }

    fun initialization() {
        mNavController = Navigation.findNavController(this, R.id.fragmentNavHost)

        setSupportActionBar(mBinding.toolbar)

        setCopyright()

        initSlider()
    }

    private fun initSlider() {
        if (AppPreferences.getAuthUser()) {
            initToolbar()

            mSlider = mBinding.slider
            //mAppSlider = AppSlider(mSlider, this)

            mAppSlider = AppSlider()
            mAppSlider.create()

            mNavController.navigate(R.id.gamblersFragment)

        } else {
            mNavController.navigate(R.id.loginFragment)
        }
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}