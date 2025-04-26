package com.jyx.billing.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("bills")
data class Bill(
    @Id val id: ObjectId = ObjectId.get(),
    val description: String,
    val issuedAt: Instant,
    val items : Map<String, Int>,
    val customerId: ObjectId
)