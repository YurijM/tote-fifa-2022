package com.example.tote_fifa_2022.utilits

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val AUTH_USER = "authUser"
    private const val NAME_PREF = "preference"

    private lateinit var mPreferences: SharedPreferences

    fun getPreference(context: Context): SharedPreferences {
        mPreferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)
        return mPreferences
    }

    fun setAuthUser(auth: Boolean) {
        mPreferences.edit()
            .putBoolean(AUTH_USER, auth)
            .apply()
    }

    fun getAuthUser(): Boolean {
        return mPreferences.getBoolean(AUTH_USER, false)
    }
}