package com.example.tote_fifa_2022.screens.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.tote_fifa_2022.firebase.FirebaseRepository
import com.example.tote_fifa_2022.utilits.REPOSITORY
import com.example.tote_fifa_2022.utilits.showToast

class LoginFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun initDatabase(onSuccess: () -> Unit) {
        REPOSITORY = FirebaseRepository()
        REPOSITORY.connectionToDatabase(
            { onSuccess() },
            { showToast(it) }
        )
    }
}