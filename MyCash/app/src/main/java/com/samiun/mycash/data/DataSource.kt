package com.samiun.mycash.data

import com.samiun.mycash.model.History

class DataSource() {

    companion object{
        val transaction = mutableListOf<History>()
    }

    fun addHistory(history: History){
        transaction.add(history)
    }
    fun total():MutableList<History>{
        return transaction
    }

}