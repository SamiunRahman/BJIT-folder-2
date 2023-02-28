package com.samiun.mynews.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.ViewModel
import com.samiun.mynews.model.Article
import com.samiun.mynews.network.NewsApi
import com.samiun.mynews.network.NewsApiService
import kotlinx.coroutines.launch


enum class NewsApiStatus{LOADING, ERROR, DONE, NOINTERNET}
class OverviewViewModel: ViewModel() {
    private val _status = MutableLiveData<NewsApiStatus>()
    val status : LiveData<NewsApiStatus> = _status

    private val _articles= MutableLiveData<List<Article>>()
    val articles : LiveData<List<Article>> = _articles

    init {

        getNewsArticles()
    }

    private fun getNewsArticles(){
        _status.value = NewsApiStatus.LOADING
        viewModelScope.launch {
            try {
                _articles.value = NewsApi.retrofitService.getArticales().articles
                Log.d("TAG", "getNewsArticles: ${articles.value}")
                _status.value = NewsApiStatus.DONE
            }
            catch (e: java.lang.Exception){
                _status.value = NewsApiStatus.ERROR
                _articles.value = listOf()
            }
        }
    }
}