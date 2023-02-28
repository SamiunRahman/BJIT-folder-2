package com.samiun.mycash.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "account_info")
@Parcelize
data class AccountInfo(
    val fistName: String,
    @PrimaryKey
    val phoneNumber: Int,
    val passWord: Int,
    var balance : Int
): Parcelable{
    fun setAmount (amount: Int){
        balance = amount
    }
}