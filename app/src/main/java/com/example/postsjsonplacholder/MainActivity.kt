package com.example.postsjsonplaceholder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.postsjsonplaceholder.presentation.ui.PostDetailScreen
import com.example.postsjsonplaceholder.presentation.ui.PostListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlin.text.Typography.dagger

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController, startDestination = "postList") {
                composable("postList") { PostListScreen(navController) }
                composable("postDetail/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) {
                    PostDetailScreen(it)
                }
            }
        }
    }
}
