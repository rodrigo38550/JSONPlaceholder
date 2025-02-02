package com.example.postsjsonplaceholder.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.example.postsjsonplaceholder.presentation.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen(backStackEntry: NavBackStackEntry, viewModel: PostViewModel = hiltViewModel()) {
    val postId = backStackEntry.arguments?.getString("id")?.toIntOrNull()
    val post by viewModel.posts.collectAsState()

    val selectedPost = post.firstOrNull { it.id == postId }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Post Detail") }) }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            selectedPost?.let {
                Text(it.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(it.body, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
