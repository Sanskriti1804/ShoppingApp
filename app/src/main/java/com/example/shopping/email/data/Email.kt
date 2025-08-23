package com.example.shopping.email.data

import kotlinx.serialization.Serializable

@Serializable
data class EmailRequest(
    val personalizations: List<Personalization>,
    val from: SendGridEmail,
    val subject: String,
    val content: List<SendGridContent>
)

data class SendGridEmail(
    val email: String,
    val name: String? = null
)

data class SendGridContent(
    val type: String = "text/plain",
    val value: String
)

data class Personalization(
    val to: List<SendGridEmail>
)
