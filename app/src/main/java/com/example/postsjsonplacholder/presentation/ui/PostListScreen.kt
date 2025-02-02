package com.example.postsjsonplacholder.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.postsjsonplacholder.presentation.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostListScreen(navController: NavController, viewModel: PostViewModel = hiltViewModel()) {
    val posts by viewModel.posts.collectAsState()

    LaunchedEffect(Unit) { viewModel.fetchPosts() }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Posts") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(posts) { post ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate("postDetail/${post.id}") },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text(post.title, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
