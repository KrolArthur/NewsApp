package com.example.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatDrawableManager.get
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.entity.Article
import com.example.newsapp.entity.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_dashboard.view.*
import kotlinx.android.synthetic.main.item.view.*


class Adapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    var articles: List<Article> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.with(context).load(articles[position].urlToImage).into(holder.imageView);
        holder.textView.text = articles[position].author
        holder.description.text = articles[position].description
        holder.relLayout.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java).apply {
                putExtra("extra", articles[position])
            }
            context.startActivity(intent)
        }
    }
    fun setdata(articless: List<Article>){
        articles = articless;
        notifyDataSetChanged()
    }

}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
    // Holds the TextView that will add each item to
    val relLayout = view.relLayout
    val textView = view.textVieww
    val imageView = view.imageView
    val description = view.textViewDescription
}