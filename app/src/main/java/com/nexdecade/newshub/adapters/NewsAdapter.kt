package com.nexdecade.newshub.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.nexdecade.newshub.R
import com.nexdecade.newshub.data.Article
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class NewsAdapter(private var articleList: List<Article>,private val onArticleClick:(Article)->Unit) : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.title)
        val descriptionView: TextView = itemView.findViewById(R.id.description)
        val publishedAt: TextView = itemView.findViewById(R.id.time)
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val itemBox:ConstraintLayout=itemView.findViewById(R.id.item_box)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_of_items, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articleList[position]

        // Set title and description
        holder.titleView.text = article.title
        holder.descriptionView.text = article.description

        //Click the title and toast the title

        holder.itemBox.setOnClickListener{


            onArticleClick(article)
        }

        // Calculate how many hours ago the article was published
        val hoursAgo: String = calculateTime(article.publishedAt)
        val timeText = "$hoursAgo hours ago"
        holder.publishedAt.text = timeText

2

        holder.imageView.load(article.urlToImage){
            placeholder(R.drawable.no_image_available_svg)
            error(R.drawable.error)
            transformations(RoundedCornersTransformation(10f))
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun calculateTime(publishedAt: String): String {
        return try {
            val apiDateTime = ZonedDateTime.parse(publishedAt)
            val currentTime = ZonedDateTime.now()
            val hoursAgo = ChronoUnit.HOURS.between(apiDateTime, currentTime)
            hoursAgo.toString()
        } catch (e: Exception) {
            "N/A" // In case of a parsing error or invalid date
        }
    }

    fun updateData(newArticles: List<Article>) {
        articleList = newArticles
        notifyDataSetChanged()
    }
}
