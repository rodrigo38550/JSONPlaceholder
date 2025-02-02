package com.example.postsjsonplacholder.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.postsjsonplacholder.presentation.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen(navController: NavController, backStackEntry: NavBackStackEntry, viewModel: PostViewModel = hiltViewModel()) {
    val postId = backStackEntry.arguments?.getString("postId")?.toIntOrNull()
    val post = viewModel.getPostById(postId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Post Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        post?.let {
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text(text = it.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.body, style = MaterialTheme.typography.bodyLarge)
            }
        } ?: Text("Post not found", modifier = Modifier.padding(16.dp))
    }
}
