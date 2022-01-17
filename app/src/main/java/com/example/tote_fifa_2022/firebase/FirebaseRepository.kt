package com.example.tote_fifa_2022.firebase

import com.example.tote_fifa_2022.utilits.EMAIL
import com.example.tote_fifa_2022.utilits.PASSWORD
import com.google.firebase.auth.FirebaseAuth

class FirebaseRepository {
    private val mAuth = FirebaseAuth.getInstance()

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        mAuth.signInWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFail(it.message.toString()) }
    }

    fun signOut() {
        mAuth.signOut()
    }
}