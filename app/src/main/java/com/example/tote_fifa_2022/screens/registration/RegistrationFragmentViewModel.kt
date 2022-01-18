package com.example.tote_fifa_2022.screens.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.tote_fifa_2022.firebase.FirebaseRepository
import com.example.tote_fifa_2022.utilits.REPOSITORY
import com.example.tote_fifa_2022.utilits.showToast

class RegistrationFragmentViewModel(appliication: Application): AndroidViewModel(appliication) {
    fun registrationUser(onSuccess: () -> Unit) {
        REPOSITORY = FirebaseRepository()
        REPOSITORY.registrationUser(
            { onSuccess() },
            { showToast(it) }
        )
    }
}