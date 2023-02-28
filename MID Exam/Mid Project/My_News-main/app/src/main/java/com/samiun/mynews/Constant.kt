package com.samiun.mynews

class Constant {
    companion object{
        val BASE_URL =
            "https://newsapi.org"


        const val type= "v2/top-headlines?country=us&"
        const val topNewsApiKey = "apiKey=158e738d4a6447db8c51dbbb7d79d7b1"

        const val TOPNEWS_END_POINT = "$type$topNewsApiKey"

    }
}