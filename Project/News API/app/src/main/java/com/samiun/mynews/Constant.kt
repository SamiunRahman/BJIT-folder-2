package com.samiun.mynews

class Constant {
    companion object{
        val BASE_URL =
            "https://newsapi.org"


        const val type= "v2/top-headlines?country=us&"
        const val apiKey = "apiKey=158e738d4a6447db8c51dbbb7d79d7b1"

        const val END_POINT = "$type$apiKey"

    }
}