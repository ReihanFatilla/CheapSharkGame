package com.ewide.test.reihan.presentation.SortSettings

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
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
        setUpSortOrderRadio()

        return binding.root
    }

    private fun setUpSortOrderRadio() {
        binding.rgSortOrder.apply {
            listSortOrder.forEach { sortOrder ->
                val radioButton = RadioButton(context)
                viewModel.getSortOrderSetting().observe(viewLifecycleOwner) { isDescending ->
                    if(!isDescending && sortOrder != "Descending") radioButton.isChecked = true
                    if(isDescending && sortOrder != "Ascending") radioButton.isChecked = true
                }
                radioButton.text = sortOrder
                radioButton.setOnClickListener {
                    val isDescending = sortOrder == "Descending"
                    viewModel.saveSortOrderSetting(isDescending)
                }
                addView(radioButton)
            }
        }
    }

    private fun setUpSortByRadio() {
        binding.rgSortBy.apply {
            listSortBy.forEach { sortBy ->
                val radioButton = RadioButton(context)
                viewModel.getSortBySetting().observe(viewLifecycleOwner) {
                    radioButton.isChecked = it == sortBy
                }
                radioButton.text = sortBy
                radioButton.setOnClickListener {
                    viewModel.saveSortBySetting(sortBy)
                }
                addView(radioButton)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val listSortBy = listOf(
            "Title",
            "Savings",
            "Price",
            "Metacritic",
            "Reviews",
            "Release",
            "Store",
            "Recent"
        )
        val listSortOrder = listOf("Ascending", "Descending")
    }
}