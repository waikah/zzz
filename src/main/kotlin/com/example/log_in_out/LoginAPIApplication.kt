package com.example.log_in_out

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
open class LoginAPIApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(LoginAPIApplication::class.java, *args)
		}
	}
}
