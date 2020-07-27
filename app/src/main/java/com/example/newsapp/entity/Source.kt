package com.example.newsapp.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Source(
    @SerializedName("id") @Expose val id: String,
    @SerializedName("name") @Expose val name: String
) : Serializable {
    override fun toString(): String{
        return "ID: $id\n" +
                "Name: $name"
    }
}
