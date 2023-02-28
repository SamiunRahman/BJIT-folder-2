package com.samiun.mycash

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.samiun.mycash.model.AccountInfo
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.*


class LogInFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        login_btn.setOnClickListener {
           val number= login_number.text.toString()
            val password = login_password.text.toString()
            if(number.length>5 && password.length>3){
                val account = AccountInfo("Samiun", number.toInt(), password.toInt(),1000)
                val action = LogInFragmentDirections.actionLogInFragmentToHomeFragment(account)
                findNavController().navigate(action)
            }
            else{
                Toast.makeText(requireContext(), "Enter a proper Number and Password", Toast.LENGTH_SHORT).show()
            }

        }
    }

}