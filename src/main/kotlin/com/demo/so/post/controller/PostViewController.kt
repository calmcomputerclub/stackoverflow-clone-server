package com.demo.so.post.controller

import com.demo.so.post.dto.PostView
import com.demo.so.post.service.PostViewService
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class PostViewController(
    private val postViewService: PostViewService
) {

    @GetMapping("/posts")
    fun allPost(): ResponseEntity<List<PostView>> {
        val postViews = postViewService.getAll()

        return ResponseEntity(postViews, HttpStatus.OK)
    }

    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<PostView> {
        val post = postViewService.getPost(id)

        return ResponseEntity(post, HttpStatus.OK)
    }
}