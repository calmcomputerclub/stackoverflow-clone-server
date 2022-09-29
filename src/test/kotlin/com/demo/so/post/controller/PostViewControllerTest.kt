package com.demo.so.post.controller

import com.demo.so.post.entity.Post
import com.demo.so.post.repository.PostRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class PostViewControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var postRepository: PostRepository

    @Test
    fun `존재하지 않는 Post 조회 시 NotFoundException`() {
        val response = mockMvc.get("/posts/9999")
        response.andExpect {
            status { isNotFound() }
        }
    }

    @Test
    fun `Post 단일 조회 200OK`() {
        val post = Post("title", "content", linkedSetOf())
        val saved = postRepository.save(post)

        val response = mockMvc.get("/posts/${saved.id}")

        response.andExpect {
            status { isOk() }
            jsonPath("$.title") { value(post.title) }
            jsonPath("$.content") { value(post.content) }
            jsonPath("$.tags") { isEmpty() }
        }
    }

    @Test
    fun `Post 전체 조회 200OK`() {

        repeat(10) {
            val post = Post("$it title", "$it content", linkedSetOf("a", "b", "c"))
            postRepository.save(post)
        }

        val response = mockMvc.get("/posts")

        response.andExpect {
            status { isOk() }
        }
    }

}