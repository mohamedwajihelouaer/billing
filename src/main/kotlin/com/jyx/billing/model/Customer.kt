package com.jyx.billing.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("customers")
data class Customer(
    @Id val id: ObjectId = ObjectId.get(),
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val address: String,
    val bills: List<Bill>
)
