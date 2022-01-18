package com.example.tote_fifa_2022.screens.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
    ): View {
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
                showToast(getString(R.string.all_fields_should_be_filled))
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
                    initSlider()
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
        val count = 6

        if (mPassword.length < count) error = getString(R.string.password_is_less_n_simbols, count)
        else if (mPassword != mPasswordConfirm) error = getString(R.string.passwords_are_not_match)

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