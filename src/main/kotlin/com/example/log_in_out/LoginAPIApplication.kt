package com.example.log_in_out

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
open class LoginAPIApplication : SpringBootServletInitializer() {
    //	companion object {
//		@JvmStatic
//		fun main(args: Array<String>) {
//			SpringApplication.run(LoginAPIApplication::class.java, *args)
//		}
//	}
    fun main(args: Array<String>) {
        runApplication<LoginAPIApplication>(*args)
    }
}
