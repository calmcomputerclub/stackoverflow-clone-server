package com.demo.so.post.dto

import com.demo.so.post.entity.Post
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class PostView private constructor(
    val id: Long,
    val title: String,
    val content: String,
    val tags: LinkedHashSet<String>,
    @field:JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime,
) {
    companion object {
        fun of(post: Post) = PostView(
            id = post.id,
            title = post.title,
            content = post.content,
            tags = post.tags,
            createdAt = post.createdAt
        )
    }
}
