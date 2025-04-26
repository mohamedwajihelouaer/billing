package com.jyx.billing.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("items")
data class Item(
    @Id val id: ObjectId = ObjectId.get(),
    val name: String,
    val description: String,
    val price: Double,
    val quantity: Int,
    val billId: ObjectId
)
