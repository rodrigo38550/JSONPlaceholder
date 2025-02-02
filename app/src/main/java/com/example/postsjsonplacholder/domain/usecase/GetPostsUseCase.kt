package com.example.postsjsonplaceholder.domain.usecase

import com.example.postsjsonplacholder.data.model.Post
import com.example.postsjsonplacholder.data.repository.PostRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke(): List<Post> = repository.getPosts()
}
