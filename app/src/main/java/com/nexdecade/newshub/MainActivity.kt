package com.nexdecade.newshub

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.nexdecade.newshub.data.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observe(viewModel.posts){
            Log.d("POSTS", "respoonse: "+it)
        }

/*        // Create the observer which updates the UI.
        val postObserver = Observer<List<Post>> { data ->
            // Update the UI, in this case, a TextView.
            Log.d("POSTS", "response: "+data)
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.posts.observe(this, postObserver)*/


        viewModel.getPostResponse()
    }
}