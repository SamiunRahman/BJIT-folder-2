package com.samiun.mynews.network

import com.samiun.mynews.Constant.Companion.BASE_URL
import com.samiun.mynews.Constant.Companion.END_POINT
import com.samiun.mynews.model.News
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET




private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface NewsApiService{

    @GET(END_POINT)
    suspend fun getArticales(): News

}

object  NewsApi
{
    val retrofitService : NewsApiService by lazy { retrofit.create(NewsApiService::class.java) }
}