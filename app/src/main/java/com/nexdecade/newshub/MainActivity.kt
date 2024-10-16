package com.nexdecade.newshub

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nexdecade.newshub.data.Article
import com.nexdecade.newshub.data.NewsData
import com.nexdecade.newshub.data.Post
import com.nexdecade.newshub.data.SourceData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var imageView: ImageView
    private lateinit var title: TextView
    private lateinit var profile: ImageView
    private lateinit var notification: ImageView
    private lateinit var tv: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // find the views by their id
        title = findViewById(R.id.pageTitle)
        imageView = findViewById(R.id.imageView4)
        profile = findViewById(R.id.profile)
        notification = findViewById(R.id.bell)
        tv = findViewById(R.id.tv)

        profile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
        notification.setOnClickListener{
            navController.navigate(R.id.notificationFragment)
        }
        tv.setOnClickListener{
            navController.navigate(R.id.TVFragment)
        }

        imageView.setOnClickListener{
            navController.navigate(
                resId = R.id.navigation_home,
                args = null,
                navOptions = navOptions {
                    launchSingleTop = true
                    popUpTo(R.id.navigation_home) {
                        inclusive = true
                    }
                }
            )
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        // Get the NavController
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_article -> {
                    title.setText("News")
                    title.visibility = View.VISIBLE
                    imageView.setImageResource(R.drawable.arrow)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 80
                    layoutParam.height = 300

                    imageView.setOnClickListener {
                        navController.popBackStack()
                    }

                }

                R.id.navigation_home -> {
                    imageView.setImageResource(R.drawable.logo_tsports)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 200
                    layoutParam.height = 200
                    title.visibility = View.INVISIBLE
                }

                R.id.profileFragment -> {
                    title.visibility = View.VISIBLE
                    title.setText("Profile")
                    imageView.setImageResource(R.drawable.arrow)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 80
                    layoutParam.height = 300
                    imageView.setOnClickListener {
                        navController.popBackStack()
                    }
                }

                R.id.notificationFragment -> {
                    title.visibility = View.VISIBLE
                    title.setText("Notification")
                    imageView.setImageResource(R.drawable.arrow)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 80
                    layoutParam.height = 300
                    imageView.setOnClickListener {
                        navController.popBackStack()
                    }
                }
                R.id.TVFragment->{
                    title.visibility = View.VISIBLE
                    title.setText("TV")
                    imageView.setImageResource(R.drawable.arrow)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 80
                    layoutParam.height = 300
                    imageView.setOnClickListener {
                        navController.popBackStack()
                    }
                }
            }
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
