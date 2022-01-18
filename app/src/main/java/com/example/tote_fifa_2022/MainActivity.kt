package com.example.tote_fifa_2022

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.tote_fifa_2022.databinding.ActivityMainBinding
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY
import com.example.tote_fifa_2022.utilits.AppPreferences
import com.example.tote_fifa_2022.utilits.START_YEAR
import com.example.tote_fifa_2022.utilits.initSlider
import com.mikepenz.materialdrawer.widget.MaterialDrawerSliderView
import java.util.*

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val mBinding get() = _binding!!
    lateinit var mNavController: NavController
    lateinit var mSlider: MaterialDrawerSliderView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this

        AppPreferences.getPreference(this)
        AppPreferences.setAuthUser(false)

        initialization()

        // Write a message to the database
        /*val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.push().setValue("Hello, World!")*/
    }

    private fun initialization() {
        mNavController = Navigation.findNavController(this, R.id.fragmentNavHost)

        setSupportActionBar(mBinding.toolbar)

        setCopyright()

        mSlider = mBinding.slider
        initSlider()
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