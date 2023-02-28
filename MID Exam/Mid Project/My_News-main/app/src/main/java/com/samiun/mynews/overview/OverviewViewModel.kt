package com.samiun.mynews.overview

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.samiun.mynews.data.ArticleBookmark
import com.samiun.mynews.data.ArticleDatabase
import com.samiun.mynews.data.ArticleEntity
import com.samiun.mynews.model.Article
import com.samiun.mynews.network.NewsApi
import com.samiun.mynews.data.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OverviewViewModel(application: Application): AndroidViewModel(application) {
    val readAllArticle: LiveData<List<ArticleEntity>>
    val readAllBookmark: LiveData<List<ArticleBookmark>>
    private val _articles= MutableLiveData<List<Article>>()
    val articles : LiveData<List<Article>> = _articles
    private val _articlesEntity= MutableLiveData<List<ArticleEntity>>()
    val articlesEntity : LiveData<List<ArticleEntity>> = _articlesEntity
    private val repository : ArticleRepository

    init {
        val articleDao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(articleDao)
        readAllArticle = repository.readAllArticle
        readAllBookmark = repository.readAllBookmark
        getTopNewsArticles()
        checkArticles()

    }

    private fun checkArticles() {
        //val viewModel = ViewModelProvider(NewsFragment()).get(OverviewViewModel::class.java)
        Log.d("Check Articles ", "getNewsArticles: ${readAllArticle.value?.get(0)?.url}")

     readAllArticle.observe(NewsFragment(), Observer { articles ->
            // Update the UI based on the value of the articles
            Log.d("Check Articles ", "getNewsArticles: ${readAllArticle.value?.get(0)?.url}")

        })

    }

    private fun getTopNewsArticles(){
        viewModelScope.launch {
            try {
                deleteArticles()
                Log.d("OverviewFragment", "Loading Data")
                _articles.value = NewsApi.retrofitService.getTopArticales().articles
                _articlesEntity.value= articles.value?.let {
                    convertToArticleEntityList(it,"Top News")
                }

                articlesEntity.value?.let { addArticleList(it) }
                Log.d("OverviewViewModel", "getNewsArticles: ${articlesEntity.value?.get(0)?.url}")
                //articlesEntity.value?.let { OverviewViewModel.addArticleList(it) }

            }
            catch (e: java.lang.Exception){
                _articles.value = listOf()
            }
        }
    }

    fun convertToArticleEntityList(articles: List<Article>, string: String): List<ArticleEntity> {
        return articles.map { article ->
            ArticleEntity(
                0,
                string,
                false,
                article.author,
                article.content,
                article.description,
                article.publishedAt,
                article.source,
                article.title,
                article.url,
                article.urlToImage
            )
        }
    }

    fun addArticleList(articleEntity: List<ArticleEntity>){
        viewModelScope.launch (Dispatchers.IO){
            repository.addArticle(articleEntity)
        }
    }


    fun deleteArticles(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllArticle()
        }
    }



    fun addBookmark(articleBookmark: ArticleBookmark){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addArticleBookmark(articleBookmark)
        }
    }

    fun updateArticle(articleEntity: ArticleEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateArticleEntity(articleEntity)
        }
    }

    fun deleteBookmark(articleBookmark: ArticleBookmark){
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(articleBookmark)
        }
    }

}