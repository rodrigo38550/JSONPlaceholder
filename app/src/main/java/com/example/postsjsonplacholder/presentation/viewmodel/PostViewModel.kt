package com.example.postsjsonplacholder.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsjsonplacholder.data.model.Post
import com.example.postsjsonplacholder.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    fun fetchPosts() {
        viewModelScope.launch {
            _posts.value = repository.getPosts()
        }
    }

    fun getPostById(postId: Int?): Post? {
        return _posts.value.find { it.id == postId }
    }
}
