package com.example.tote_fifa_2022.screens.emails.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tote_fifa_2022.R
import com.example.tote_fifa_2022.databinding.FragmentEmailsBinding
import com.example.tote_fifa_2022.utilits.APP_ACTIVITY

class EmailsFragment : Fragment() {
    private var _binding: FragmentEmailsBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentEmailsBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()

        mBinding.btnAddEmail.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("title", getString(R.string.add_email))

            APP_ACTIVITY.mNavController.navigate(
                R.id.action_emailsFragment_to_emailEditFragment,
                bundle
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}