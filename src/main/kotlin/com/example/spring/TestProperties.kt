package com.example.spring

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component


@Component
@ConfigurationProperties(prefix = "student")
data class TestProperties(
    var name: String? = null,
    var age: Int? = null
)

