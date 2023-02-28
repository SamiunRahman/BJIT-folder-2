package com.samiun.mynews.data
import android.accounts.Account
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class, ArticleBookmark::class], version = 1, exportSchema = false)
abstract class ArticleDatabase:RoomDatabase(){
    abstract fun articleDao(): ArticleDao

    companion object{
        @Volatile
        private var INSTANCE: ArticleDatabase?= null

        fun getDatabase(context: Context): ArticleDatabase{
            val tempInstace = INSTANCE
            if (tempInstace!=null){
                return tempInstace
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}