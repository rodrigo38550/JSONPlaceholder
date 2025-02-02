package com.example.postsjsonplacholder.data.repository

import com.example.postsjsonplacholder.data.model.Post
import com.example.postsjsonplacholder.data.remote.ApiService
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPosts(): List<Post> = apiService.getPosts()
    suspend fun getPostById(id: Int): Post = apiService.getPostById(id)
}
