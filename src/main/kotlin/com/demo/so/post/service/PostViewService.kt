package com.demo.so.post.service

import com.demo.so.post.dto.PostView
import com.demo.so.post.exception.PostNotFoundException
import com.demo.so.post.repository.PostRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostViewService(
    private val postRepository: PostRepository
) {
    fun getAll(): List<PostView> {
        return postRepository.findAll()
            .map { PostView.of(it) }
    }

    fun getPost(id: Long): PostView {
        val post = postRepository.findByIdOrNull(id)
            ?: throw PostNotFoundException()
        return PostView.of(post)
    }
}