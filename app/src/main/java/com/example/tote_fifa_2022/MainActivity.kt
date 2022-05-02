package com.example.tote_fifa_2022

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.ViewConfiguration
import android.widget.Toast
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
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val item = mBinding.toolbar.menu.findItem(R.id.stake)
        Log.d("abc", item.toString())
        return true
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("abc", item.itemId.toString())
        Log.d("abc", R.id.stake.toString())
        when (item.itemId) {
            android.R.id.home -> mSlider.drawerLayout?.openDrawer(mSlider)
            R.id.stake -> Toast.makeText(this, "Ставки", Toast.LENGTH_LONG).show()
        }
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}