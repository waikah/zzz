package com.example.log_in_out.authentication.dao.database.token

import javax.persistence.*

@Entity
@Table(name = "token")
data class Token(
        @Id
        @Column(name = "authentication_token", nullable = false, unique = true, updatable = false)
        var authenticationToken: String,

        @Column(name = "user_id", nullable = false, updatable = false)
        var userId: Long
)
