package com.example.tote_fifa_2022.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.databinding.FragmentLoginBinding
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY
import com.example.tote_fifa_2022.utilits.AppPreferences
import com.example.tote_fifa_2022.utilits.EMAIL
import com.example.tote_fifa_2022.utilits.PASSWORD

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: LoginFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mViewModel = ViewModelProvider(this).get(LoginFragmentViewModel::class.java)

        if (AppPreferences.getAuthUser()) {
            APP_ACTIVITY.initialization()

            mViewModel.connectionToDatabase() {
                APP_ACTIVITY.mNavController.navigate(R.id.action_loginFragment_to_gamblersFragment)
            }
        } else {
            initialization()
        }
    }

    private fun initialization() {
        mBinding.txtToRegistration.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        mBinding.btnLogin.setOnClickListener {
            var email = mBinding.inputEmail.text.toString()
            var password = mBinding.inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                EMAIL = email
                PASSWORD = password

                mViewModel.connectionToDatabase {
                    AppPreferences.setAuthUser(true)
                    APP_ACTIVITY.mNavController.navigate(R.id.action_loginFragment_to_gamblersFragment)
                }
            } else {
                if (email.isEmpty()) mBinding.inputEmail.error = getString(R.string.enter_email)
                if (password.isEmpty()) mBinding.inputPassword.error = getString(R.string.enter_password)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}