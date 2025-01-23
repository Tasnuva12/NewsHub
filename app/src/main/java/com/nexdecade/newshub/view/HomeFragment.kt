package com.nexdecade.newshub.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nexdecade.newshub.R
import com.nexdecade.newshub.adapters.NewsAdapter
import com.nexdecade.newshub.data.Article
import com.nexdecade.newshub.models.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    //recyclerview
    private lateinit var recyclerView: RecyclerView
    //adapter
    private lateinit var adapter: NewsAdapter
     //viewmodel
    private val viewModel by activityViewModels<MainViewModel>()

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //link to recyclerview in fragment
        recyclerView = view.findViewById(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(context)

        //initialize  adapter
        adapter = NewsAdapter(emptyList()) { article ->
            goToArticleFragment(article)
        }
        recyclerView.adapter = adapter

        //observe livedata  from view
        val newsObserver = Observer<List<Article>> { data ->
            Log.d("News", "response:$data")

            adapter.updateData(data)
        }
        viewModel.news.observe(viewLifecycleOwner, newsObserver)

        viewModel.getPostResponse()

    }

    private fun goToArticleFragment(article: Article) {
        //this iis necessary because navigate function expects a bundle to pass
//        val bundle =Bundle().apply{
//            putSerializable("article_key",article)
//        }
        Log.d("Hello", "goToArticleFragment: $article")

        viewModel.selectedArticle.value = article
        findNavController().navigate(R.id.navigation_article)
    }



}