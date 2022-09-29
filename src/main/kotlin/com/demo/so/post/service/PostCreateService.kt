package com.demo.so.post.service

import com.demo.so.post.dto.PostCreateDto
import com.demo.so.post.dto.PostView
import com.demo.so.post.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostCreateService(
    private val postRepository: PostRepository
) {

    @Transactional
    fun create(dto: PostCreateDto): PostView {
        val post = postRepository.save(dto.toEntity())
        return PostView.of(post)
    }
}