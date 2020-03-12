package com.example.log_in_out

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class LoginAPIApplication : SpringBootServletInitializer()

fun main(args: Array<String>) {
    runApplication<LoginAPIApplication>(*args)
}

