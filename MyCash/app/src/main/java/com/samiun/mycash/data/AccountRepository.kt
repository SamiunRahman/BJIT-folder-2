package com.samiun.mycash.data

import androidx.lifecycle.LiveData
import com.samiun.mycash.model.AccountInfo

class AccountRepository(private val accountDao: AccountDao) {
    val readAllAccount : LiveData<List<AccountInfo>> = accountDao.readAllAccount()

    suspend fun addAccount(accountInfo: AccountInfo){
        accountDao.addAccount(accountInfo)
    }

    suspend fun deleteAccount(accountInfo: AccountInfo){
        accountDao.deleteAccount(accountInfo)
    }

    suspend fun updateAccount (accountInfo: AccountInfo){
        accountDao.updateAccount(accountInfo)
    }


}