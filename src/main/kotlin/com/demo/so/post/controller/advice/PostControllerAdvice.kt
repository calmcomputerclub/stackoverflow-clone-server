package com.demo.so.post.controller.advice

import com.demo.so.post.controller.PostCreateController
import com.demo.so.post.exception.PostNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(basePackageClasses = [PostCreateController::class])
class PostControllerAdvice {

    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(PostNotFoundException::class)
    fun notFound(e: PostNotFoundException): ResponseEntity<String> {

        log.error(e.message, e)

        return ResponseEntity(HttpStatus.NOT_FOUND)
    }
}