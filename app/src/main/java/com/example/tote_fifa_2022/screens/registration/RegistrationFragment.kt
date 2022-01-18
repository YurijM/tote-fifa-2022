package com.example.tote_fifa_2022.screens.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.databinding.FragmentRegistrationBinding
import com.example.tote_fifa_2022.utilits.*

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: RegistrationFragmentViewModel
    private lateinit var mFamily: String
    private lateinit var mName: String
    private lateinit var mNickname: String
    private lateinit var mEmail: String
    private lateinit var mPassword: String
    private lateinit var mPasswordConfirm: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(RegistrationFragmentViewModel::class.java)

        mBinding.btnRegister.setOnClickListener {
            initFields()

            var error = false

            if (!checkEmptyFields()) {
                showToast("Все поля должны быть заполнены")
                error = true
            } else {
                val message = checkPasswordConfirm()
                if (message.isNotEmpty()) {
                    showToast(message)
                    error = true
                }
            }

            if (!error) {
                EMAIL = mEmail
                PASSWORD = mPassword

                mViewModel.registrationUser {
                    AppPreferences.setAuthUser(true)
                    APP_ACTIVITY.mNavController.navigate(R.id.action_registrationFragment_to_gamblersFragment)
                }
            }
        }
    }

    private fun initFields() {
        mFamily = mBinding.inputRegFamily.text.toString()
        mName = mBinding.inputRegName.text.toString()
        mNickname = mBinding.inputRegNickname.text.toString()
        mEmail = mBinding.inputRegEmail.text.toString()
        mPassword = mBinding.inputRegPassword.text.toString()
        mPasswordConfirm = mBinding.inputRegPasswordConfirm.text.toString()
    }

    private fun checkPasswordConfirm(): String {
        var error = ""

        if (mPassword.length < 6) error = "Пароль должен содержать не менее 6 символов"
        else if (mPassword != mPasswordConfirm) error = "Пароли не совпадают"

        return error
    }

    private fun checkEmptyFields(): Boolean {
        var check = true

        for (field in listOf(
            mFamily,
            mName,
            mNickname,
            mEmail,
            mPassword,
            mPasswordConfirm
        )) {
            if (field.isEmpty()) {
                check = false
                break
            }
        }

        return check
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}