package com.samiun.mycash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.samiun.mycash.data.DataSource
import com.samiun.mycash.model.History
import kotlinx.android.synthetic.main.fragment_histoy.*
import kotlinx.android.synthetic.main.fragment_send_money.*

class SendMoneyFragment : Fragment() {

    val getArgs: SendMoneyFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getAccount = getArgs.account
        send_btn.setOnClickListener {
            val number = send_num.text.toString()
            val amount = send_amount.text.toString()
            if(number.length>5 && amount.toInt()<getAccount!!.balance){
                val balance = getAccount.balance-amount.toInt()
                getAccount.setAmount(balance)
                Toast.makeText(requireContext(), "balance $balance", Toast.LENGTH_SHORT).show()
                val action = SendMoneyFragmentDirections.actionSendMoneyFragmentToHomeFragment(getAccount)
                //findNavController().navigate(action)
                val data = DataSource()
                val history = History(number,amount)
                data.addHistory(history)
                val liveData = MutableLiveData<String>()

// Observe the LiveData object in an activity or fragment
                liveData.observe(viewLifecycleOwner, Observer { value ->
                    // Update the UI with the new value
                    textviewsend.text = value
                })

// Update the value of the LiveData object
                liveData.value = send_num.text.toString()
            }
            else if(number.length<6){
                Toast.makeText(requireContext(), "Enter a proper receivers number!", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(requireContext(), "You dont have enough balance!", Toast.LENGTH_SHORT).show()
            }
        }
    }


}