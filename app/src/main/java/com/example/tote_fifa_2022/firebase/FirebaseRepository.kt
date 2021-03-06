package com.example.tote_fifa_2022.firebase

import com.example.tote_fifa_2022.utilits.*
import com.google.firebase.auth.FirebaseAuth

class FirebaseRepository {
    init {
        AUTH = FirebaseAuth.getInstance()
    }

    fun connectionToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        if (AppPreferences.getAuthUser()) {
            CURRENT_ID = AUTH.currentUser?.uid.toString()
            onSuccess()
        } else {
            AUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
                .addOnSuccessListener {
                    CURRENT_ID = AUTH.currentUser?.uid.toString()
                    onSuccess()
                }
                .addOnFailureListener {
                    onFail(it.message.toString())

                    /*AUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                        .addOnSuccessListener {
                            CURRENT_ID = AUTH.currentUser?.uid.toString()
                            onSuccess()
                        }
                        .addOnFailureListener { onFail(it.message.toString()) }*/
                }
        }
    }
    fun registrationUser(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        AUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
            .addOnSuccessListener {
                CURRENT_ID = AUTH.currentUser?.uid.toString()
                onSuccess()
            }
            .addOnFailureListener { onFail(it.message.toString()) }
    }

    fun signOut() {
        AUTH.signOut()
    }
}