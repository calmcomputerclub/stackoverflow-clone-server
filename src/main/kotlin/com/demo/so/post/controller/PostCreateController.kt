package com.demo.so.post.controller

import com.demo.so.post.dto.PostCreateDto
import com.demo.so.post.dto.PostView
import com.demo.so.post.service.PostCreateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PostCreateController(
    private val postCreateService: PostCreateService
) {

    @PostMapping("/post")
    fun create(
        @RequestBody post: PostCreateDto
    ): ResponseEntity<PostView> {
        val post = postCreateService.create(post)

        return ResponseEntity(post, HttpStatus.CREATED)
    }
}