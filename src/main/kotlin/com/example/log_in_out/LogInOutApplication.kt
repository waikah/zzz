package com.example.log_in_out

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class LogInOutApplication{
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(LogInOutApplication::class.java, *args)
		}
	}
}