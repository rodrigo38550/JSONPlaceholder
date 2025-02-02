package com.example.postsjsonplaceholder.data.repository

import com.example.postsjsonplaceholder.data.model.Post
import com.example.postsjsonplaceholder.data.remote.ApiService
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPosts(): List<Post> = apiService.getPosts()
    suspend fun getPostById(id: Int): Post = apiService.getPostById(id)
}
