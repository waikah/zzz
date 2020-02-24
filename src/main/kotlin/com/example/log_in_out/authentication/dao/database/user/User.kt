package com.example.log_in_out.authentication.dao.database.user

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "user_id", nullable = false, unique = true, updatable = false)
        val id: Long,

        @Column(name = "username", nullable = false, unique = true, updatable = false)
        val username: String,

        @Column(name = "password", nullable = false)
        val password: String
)
