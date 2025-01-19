package com.nexdecade.newshub

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var imageView: ImageView
    private lateinit var title: TextView
    private lateinit var profile: ImageView
    private lateinit var search: ImageView
    private lateinit var favourite: ImageView


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
        imageView = findViewById(R.id.newsLogo)

        search = findViewById(R.id.search)
        favourite = findViewById(R.id.favourite)


        search.setOnClickListener{
            navController.navigate(R.id.searchFragment)
        }
        favourite.setOnClickListener{
            navController.navigate(R.id.favouriteFragment)
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
                    imageView.setImageResource(R.drawable.news_icon)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 200
                    layoutParam.height = 200
                    title.visibility = View.INVISIBLE
                }



                R.id.searchFragment -> {
                    title.visibility = View.VISIBLE
                    title.setText("Search")
                    imageView.setImageResource(R.drawable.arrow)
                    val layoutParam = imageView.layoutParams
                    layoutParam.width = 80
                    layoutParam.height = 300
                    imageView.setOnClickListener {
                        navController.popBackStack()
                    }
                }
                R.id.favouriteFragment->{
                    title.visibility = View.VISIBLE
                    title.setText("Favourite")
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
