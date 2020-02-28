package com.example.log_in_out.authentication.dao.database.user

import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User, Long> {
    //find user data by using their username
    fun findByUsername(username: String): Optional<User>
}
