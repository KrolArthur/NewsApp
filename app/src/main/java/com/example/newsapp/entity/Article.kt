package com.example.newsapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article (
    @SerializedName("source") @Expose val source: Source,
    @SerializedName("author") @Expose val author: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("description") @Expose val description: String,
    @SerializedName("url") @Expose val url: String,
    @SerializedName("urlToImage") @Expose val urlToImage: String,
    @SerializedName("publishedAt") @Expose val publishedAt: String,
    @SerializedName("content") @Expose val content: String
): Serializable{
    override fun toString(): String{
        return "Source: ${source.toString()}\n" +
                "\nAuthor: $author\n" +
                "\nTitle: $title\n" +
                "\nDescription: $description\n" +
                "\nURL: $url\n" +
                "\nImage URL: $urlToImage\n" +
                "\nPublished at: $publishedAt\n" +
                "\nContent : $content"
    }
}
