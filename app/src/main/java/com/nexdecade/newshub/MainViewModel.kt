package com.nexdecade.newshub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexdecade.newshub.Constants.Companion.API_KEY
import com.nexdecade.newshub.data.Article
import com.nexdecade.newshub.data.NewsData
import com.nexdecade.newshub.data.NewsDataRepository
import com.nexdecade.newshub.data.SourceData
import com.nexdecade.newshub.data.SourceDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val postRepository: PostRepository
    //private val sourceRepo:SourceDataRepository
    private val newsRepo:NewsDataRepository
): ViewModel() {
   // val posts = MutableLiveData<List<Post>>()
//    private val _source=MutableLiveData<SourceData>()
//    val source:LiveData<SourceData> get()= _source

    private val _news=MutableLiveData<List<Article>>()
    val news: MutableLiveData<List<Article>> get() = _news

    val selectedArticle = MutableLiveData<Article>()






    fun getPostResponse(){
        viewModelScope.launch {
           // val response = postRepository.getPosts()
            //posts.value = response

            val response =newsRepo.getNewsData()

            if (response.status == "ok"){
                _news.value = response.articles
            }
        }
    }
    fun randomArticle(count:Int=3):List<Article>{
        val random= mutableListOf<Article>()
        val list: List<Article>? =_news.value
        if (list != null) {
            for (item in list){
                if(item!=selectedArticle.value){
                    random.add(item)
                }
            }
        }
        //shuffle them
        for(i in random.size-1 downTo 1){
            val j=(0..i).random()
            val temp= random[i]
            random[i]=random[j]
            random[j]=temp
        }
        //3 random article
        val randomArticles= mutableListOf<Article>()
        for(i in 0 until  minOf(3,random.size)){
            randomArticles.add(random[i])
        }
        return randomArticles





    }
}