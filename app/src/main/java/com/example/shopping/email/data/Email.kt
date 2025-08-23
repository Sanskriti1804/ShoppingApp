package com.example.shopping.email.data

import kotlinx.serialization.Serializable

@Serializable
data class EmailRequest(
    val personalizations: List<Personalization>,
    val content: List<Content>,
    val from: EmailInfo,
    val reply_to: EmailInfo? = null
)

data class Personalization(
    val to: List<EmailInfo>,
    val subject: String
)

data class Content(
    val type: String,
    val value: String
)

data class EmailInfo(
    val email: String,
    val name: String? = null
)
