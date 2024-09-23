package com.nexdecade.newshub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nexdecade.newshub.data.Post
import com.nexdecade.newshub.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    val posts = MutableLiveData<List<Post>>()

    fun getPostResponse(){
        viewModelScope.launch {
            val response = postRepository.getPosts()
            posts.value = response
        }
    }
}