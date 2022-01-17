package com.example.tote_fifa_2022.utilits

import com.example.tote_fifa_2022.MainActivity
import com.example.tote_fifa_2022.firebase.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var APP_ACTIVITY: MainActivity

lateinit var REPOSITORY: FirebaseRepository
lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var DATABASE_REF: DatabaseReference

const val START_YEAR = 2021

lateinit var EMAIL: String
lateinit var PASSWORD: String