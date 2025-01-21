package com.nexdecade.newshub.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nexdecade.newshub.R
import com.nexdecade.newshub.models.Article

class ReadMoreAdapter(private var articles: List<Article>, private val onClick: (Article) -> Unit) :
    RecyclerView.Adapter<ReadMoreAdapter.ReadMoreViewHolder>() {
    class ReadMoreViewHolder(view: View): RecyclerView.ViewHolder(view) {
        //readmore
        val readMoreTitle:TextView=view.findViewById(R.id.readMoreTitle)
       val  readMoreImage:ImageView=view.findViewById(R.id.readMoreImage)
           val itemBox: LinearLayout =itemView.findViewById(R.id.readMoreItem)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadMoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.read_more, parent, false)
        return ReadMoreViewHolder(view)
    }

    override fun getItemCount(): Int = articles.size



    override fun onBindViewHolder(holder: ReadMoreViewHolder, position: Int) {
        val article = articles[position]

        holder.readMoreTitle.text = article.title
        holder.readMoreImage.load(article.urlToImage) {
            placeholder(R.drawable.no_image_available_svg)
            error(R.drawable.error)
        }
        holder.itemBox.setOnClickListener{
         onClick (article)

        }


    }
    fun updateData(newArticles: List<Article>) {
        articles = newArticles
        notifyDataSetChanged()
    }

}