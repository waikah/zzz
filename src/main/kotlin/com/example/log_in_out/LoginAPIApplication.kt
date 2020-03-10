package com.example.log_in_out

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class LoginAPIApplication

fun main(args: Array<String>) {
	runApplication<LoginAPIApplication>(*args)
}
