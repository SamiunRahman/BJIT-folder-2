package com.samiun.mycash.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.samiun.mycash.model.AccountInfo

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addAccount(accountInfo: AccountInfo)

    @Query("Select * from account_info order by fistName asc")
    fun readAllAccount(): LiveData<List<AccountInfo>>

    @Update
    suspend fun updateAccount(accountInfo: AccountInfo)
    @Delete
    suspend fun deleteAccount(accountInfo: AccountInfo)



}