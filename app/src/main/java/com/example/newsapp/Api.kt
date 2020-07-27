package com.example.newsapp

import com.example.newsapp.entity.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {
    @GET("top-headlines?apikey=a18ac48f4fac446aa8947114551abbb7")
    fun getNews(@QueryMap map:Map<String, String>): Call<News>
}