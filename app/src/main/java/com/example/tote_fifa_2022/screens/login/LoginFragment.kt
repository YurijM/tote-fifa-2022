package com.example.tote_fifa_2022.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.databinding.FragmentLoginBinding
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val mBinding get() = _binding!!

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

        mBinding.txtToRegistration.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        mBinding.btnLogin.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_loginFragment_to_gamblersFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}