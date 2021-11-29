package com.example.fragmentnew.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.fragmentnew.R

class ExampleDialog: AppCompatDialogFragment() {

    lateinit var listener: ExampleDialogListener;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.dialog_layout, null)

        var firstName: EditText? = view?.findViewById(R.id.editTextFirstName)
        var lastName: EditText? = view?.findViewById(R.id.editTextSecondName)

        builder.setView(view)
            .setTitle("Enter your personal information")
            .setPositiveButton("Save", DialogInterface.OnClickListener{dialog, which ->
                val firstNameValue: String = firstName?.text.toString()
                val lastNameValue: String = lastName?.text.toString()

                listener.setText(firstNameValue, lastNameValue)

            })
            .setNegativeButton("Exit", DialogInterface.OnClickListener{dialog, which ->

            })

        return builder.create()
    }

    fun setExampleDialogListener(listener: ExampleDialogListener) {
        this.listener = listener
    }

    public interface ExampleDialogListener {
        fun setText(firstName: String, secondName: String)
    }
}