package com.demo.so.post.repository

import com.demo.so.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long>