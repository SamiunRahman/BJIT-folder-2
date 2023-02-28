package com.samiun.mycash.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.samiun.mycash.data.AccountRepository
import com.samiun.mycash.data.Database
import com.samiun.mycash.model.AccountInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountViewModel(application: Application) : AndroidViewModel(application) {
    val readAlldata: LiveData<List<AccountInfo>>

    private val repository: AccountRepository
    init{
        val accountDao = Database.getDatabase(application).AccountDao()
        repository = AccountRepository(accountDao)
        readAlldata = repository.readAllAccount

    }

    fun addAccount(accountInfo: AccountInfo){
        viewModelScope.launch(Dispatchers.IO){
            repository.addAccount(accountInfo)
        }
    }

    fun deleteAccount(accountInfo: AccountInfo){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAccount(accountInfo)
        }
    }

    fun updateAccount(accountInfo: AccountInfo){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateAccount(accountInfo)
        }
    }
}