package com.ewide.test.reihan.presentation.SortSettings

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ewide.test.reihan.databinding.FragmentSortDialogBinding
import com.ewide.test.reihan.presentation.home.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SortSettingsDialogFragment : DialogFragment() {

    private var _binding: FragmentSortDialogBinding? = null
    private val binding get() = _binding as FragmentSortDialogBinding

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSortDialogBinding.inflate(layoutInflater)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}