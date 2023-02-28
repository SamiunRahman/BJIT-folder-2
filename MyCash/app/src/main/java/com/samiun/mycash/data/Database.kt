package com.samiun.mycash.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.samiun.mycash.model.AccountInfo

@Database(entities = [AccountInfo::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun AccountDao(): AccountDao

    companion object{
        @Volatile
        private var INSTANCE: com.samiun.mycash.data.Database? = null

        fun getDatabase(context: Context): com.samiun.mycash.data.Database{
            val tempInstance = INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instace = Room.databaseBuilder(
                    context.applicationContext,
                    com.samiun.mycash.data.Database::class.java,
                    "account_database"
                ).build()
                INSTANCE= instace
                return instace
            }
        }
    }

}