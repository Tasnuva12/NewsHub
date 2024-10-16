package com.nexdecade.newshub

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.nexdecade.newshub.data.Article
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment() {
    //recyclerview
    private lateinit var recyclerView: RecyclerView
    //adapter
    private lateinit var adapter: NewsAdapter
    private lateinit var adapterReadMore:ReadMoreAdapter
    //viewmodel
    private val viewModel by activityViewModels<MainViewModel>()

    private lateinit var articleImageView: ImageView
    private lateinit var textOfImage:TextView
    private lateinit var titleOfNews:TextView
    private lateinit var  time_and_date:TextView
    private lateinit var description_of_news:TextView

    //readmore
    private lateinit var readMoreTitle: TextView
    private lateinit var readMoreImage:ImageView

    private  var article:Article?=null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          //recycler view
        recyclerView=view.findViewById(R.id.recycleReadMore)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val randomArticles=viewModel.randomArticle(3)

        adapterReadMore=ReadMoreAdapter(randomArticles){ selectedArticle->
            Log.d("ArticleFragment", "Selected Article: $selectedArticle")
            getItem(selectedArticle)
        }
        recyclerView.adapter=adapterReadMore
        adapterReadMore.updateData(randomArticles)



        article = viewModel.selectedArticle.value
        Log.d("Hello", "onViewCreated: $article")

        articleImageView=view.findViewById(R.id.articleImage)
        textOfImage=view.findViewById(R.id.imageText)
        titleOfNews=view.findViewById(R.id.title)
        time_and_date=view.findViewById(R.id.time_and_date)
        description_of_news=view.findViewById(R.id.description)

        articleImageView.load(article?.urlToImage){
            placeholder(R.drawable.no_image_available_svg)
            error(R.drawable.error)
            transformations(RoundedCornersTransformation(10f))
        }

        textOfImage.text= article?.title ?: "no image  available"
        titleOfNews.text=article?.title?:"no title available"
        time_and_date.text= article?.publishedAt ?: "no time available"
        description_of_news.text= article?.description ?: "no description available "
    }

    private fun getItem(selectedArticle: Article) {
        viewModel.selectedArticle.value = selectedArticle
        findNavController().navigate(
            resId = R.id.navigation_article,
            args = null,
            navOptions = navOptions {
                launchSingleTop = true
//                popUpTo(R.id.navigation_article){
//                    inclusive = false
//                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        viewModel.selectedArticle.value = null
    }
}