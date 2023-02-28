package com.samiun.mysharedpreference
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SmsReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "SMS Received!", Toast.LENGTH_SHORT).show()
    }
}
