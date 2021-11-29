package com.example.fragmentnew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.fragmentnew.dialog.ExampleDialog


class ThirdFragment : Fragment(), ExampleDialog.ExampleDialogListener {

    lateinit var firstNameTextView: TextView
    lateinit var secondNameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_third, container, false)

        val dialogButton = view.findViewById<Button>(R.id.dialogButon)

        dialogButton.setOnClickListener{
            openDialog()
        }

        firstNameTextView = view.findViewById<TextView>(R.id.dialogFirstName)
        secondNameTextView = view.findViewById<TextView>(R.id.dialogSecondName)

        return view
    }

    private fun openDialog() {
        var dialogInstance = ExampleDialog()
        dialogInstance.setExampleDialogListener(this)
        fragmentManager?.let { dialogInstance.show(it, "Example Dialog") }
    }

    override fun setText(firstName: String, secondName: String) {
        firstNameTextView.text = firstName
        secondNameTextView.text = secondName
    }


}