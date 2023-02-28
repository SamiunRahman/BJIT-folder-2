package com.samiun.mycash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    val getArgs : HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getAccount = getArgs.account
        home_name.text = "Welcome, ${getAccount?.fistName}"
        home_phone.text = "+880"+getAccount?.phoneNumber.toString()
        home_balance.text = "Balance: $ "+getAccount?.balance.toString()
        home_send_btn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSendMoneyFragment(getAccount)
            findNavController().navigate(action)
        }
        home_history_btn.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToHistoyFragment(getAccount)
            findNavController().navigate(action)
        }



    }
}