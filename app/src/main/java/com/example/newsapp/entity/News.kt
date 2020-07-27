package com.example.newsapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class News (
    @SerializedName("status") @Expose val author: String,
    @SerializedName("totalResult") @Expose val totalResult: String,
    @SerializedName("articles") @Expose val articles: List<Article>
    )