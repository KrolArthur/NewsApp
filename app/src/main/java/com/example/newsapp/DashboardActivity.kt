package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.entity.Article
import com.example.newsapp.entity.News
import kotlinx.android.synthetic.main.activity_dashboard.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class DashboardActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = Adapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val api: Api = retrofit.create(Api::class.java)
        var hashMap: HashMap<String, String> = HashMap<String, String>()
        hashMap.put("country", "us")

        val call = api.getNews(hashMap)
        call.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                /*textVieww.text = t.message*/
            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (!response.isSuccessful) {
           /*         textView.text =
                        "Code" + response.code().toString() + "\n" + call.request().url()*/
                }
                recyclerAdapter.setdata(response.body()!!.articles)
            }

        })

    }
}