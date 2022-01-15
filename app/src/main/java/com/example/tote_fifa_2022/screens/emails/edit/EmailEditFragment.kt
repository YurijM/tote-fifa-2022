package com.example.tote_fifa_2022.screens.emails.edit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.databinding.FragmentEmailEditBinding
import com.example.tote_fifa_2022.databinding.FragmentEmailsBinding
import com.example.tote_fifa_2022.databinding.FragmentLoginBinding
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY

class EmailEditFragment : Fragment() {
    private var _binding: FragmentEmailEditBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEmailEditBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mBinding.txtEditEmail.text = arguments?.getString("title")

        mBinding.btnCancelEmail.setOnClickListener {
            APP_ACTIVITY.mNavController.navigate(R.id.action_emailEditFragment_to_emailsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}