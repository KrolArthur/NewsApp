package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.entity.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val article: Article = intent.getSerializableExtra("extra") as Article
        Picasso.with(this).load(article.urlToImage).into(img)
        txtView.text = article.content

        returnBtn.setOnClickListener {
            finish()
        }

    }
}