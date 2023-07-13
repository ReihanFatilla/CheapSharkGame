package com.ewide.test.reihan.presentation.SortSettings

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import com.ewide.test.reihan.databinding.FragmentSettingDialogBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SettingDialogFragment : DialogFragment() {

    private var _binding: FragmentSettingDialogBinding? = null
    private val binding get() = _binding as FragmentSettingDialogBinding

    private val viewModel: SettingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSettingDialogBinding.inflate(layoutInflater)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setUpSortByRadio()

        return binding.root
    }

    private fun setUpSortByRadio() {
        binding.rgSortBy.apply {
            
            setOnCheckedChangeListener { _, checkedId ->
                val radioButton = findViewById<RadioButton>(checkedId)
                viewModel.saveSortBySetting(radioButton.text.toString())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}