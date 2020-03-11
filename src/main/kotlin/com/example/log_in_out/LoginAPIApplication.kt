package com.example.log_in_out

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.StorageOptions
import com.google.common.collect.Lists
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.FileInputStream
import java.io.IOException


@SpringBootApplication
open class LoginAPIApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(LoginAPIApplication::class.java, *args)
		}
	}
}
