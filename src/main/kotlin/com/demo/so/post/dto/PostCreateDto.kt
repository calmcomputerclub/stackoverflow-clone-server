package com.demo.so.post.dto

import com.demo.so.post.entity.Post

data class PostCreateDto(
    val title: String,
    val content: String,
    val tags: LinkedHashSet<String> = linkedSetOf()
) {
    fun toEntity(): Post = Post(
        title,
        content,
        tags
    )
}