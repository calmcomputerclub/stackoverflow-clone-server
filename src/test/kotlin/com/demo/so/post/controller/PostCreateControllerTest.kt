package com.demo.so.post.controller

import com.demo.so.post.dto.PostCreateDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@AutoConfigureMockMvc
@SpringBootTest
internal class PostCreateControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `Post 등록 요청 시 200 OK`() {

        val request = PostCreateDto("title-", "content", linkedSetOf("H", "E", "L", "L", "O"))

        val jsonBody = objectMapper.writeValueAsString(request)

        val response = mockMvc.post("/post") {
            contentType = MediaType.APPLICATION_JSON
            content = jsonBody
        }

        response.andExpect {
            status { isCreated() }
            jsonPath("$.title") { value(request.title) }
            jsonPath("$.content") { value(request.content) }
            jsonPath("$.tags") { prefix(objectMapper.writeValueAsString(request.tags))  }
        }.andDo { print() }
    }
}