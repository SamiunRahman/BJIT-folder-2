package com.samiun.mynews.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.samiun.mynews.typecoverter.SourceConverter

@Database(entities = [ArticleEntity::class, ArticleBookmark::class], version = 3, exportSchema = false)
@TypeConverters(SourceConverter::class)

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
                )
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}