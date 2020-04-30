package com.codemen.games.ui.fragment.dialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.codemen.games.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_sheet_dialog.*

/**
 ** create by ErixJavier on  27/04/20.
 */
class BottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPlannedDate.setOnClickListener{
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {
        val newFragment = DatePickerFragment.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
            // +1 because January is zero
            val selectedDate = day.toString() + " / " + (month + 1) + " / " + year
         //   etBirthDate.setText(selectedDate)
        })

        newFragment.show((activity as AppCompatActivity).supportFragmentManager, "datePicker")
    }
}

