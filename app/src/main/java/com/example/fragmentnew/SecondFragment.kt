package com.example.fragmentnew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultTextView = view.findViewById<TextView>(R.id.result)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {

//            CoroutineScope(Dispatchers.IO).launch {
//                var result = callApiWithCoroutines()
//
//                withContext(Dispatchers.Main) {
//                    resultTextView.text = result
//                }
//            }

            CoroutineScope(Dispatchers.Main).launch {
                val currentTime = System.currentTimeMillis()
                val resultValue1 = async (Dispatchers.IO) {downloadTask1()}
                val resultValue2 = async (Dispatchers.IO) {downloadTask2()}
                val resultValue3 = async (Dispatchers.IO) {downloadTask3()}

                Toast.makeText(activity, "All tasks downloaded! ${resultValue1.await()}, ${resultValue2.await()}, ${resultValue3.await()}", Toast.LENGTH_LONG).show()
                resultTextView.text = "" + ((System.currentTimeMillis() - currentTime) / 1000) + " seconds"

            }
        }
    }

    private fun callApi(): String {
        val res = "This is a result from api request!"


        return res
    }

    private suspend fun callApiWithCoroutines(): String {
        val res = "This is a result from api request!"

        Thread.sleep(8000)

        return res
    }


    private suspend fun downloadTask1(): String {
        kotlinx.coroutines.delay(5000)
        return "Task completed"
    }

    private suspend fun downloadTask2(): Int {
        kotlinx.coroutines.delay(10000)
        return 100
    }

    private suspend fun downloadTask3(): Float {
        kotlinx.coroutines.delay(5000)
        return 5.0f
    }


}