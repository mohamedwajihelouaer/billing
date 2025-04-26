package com.jyx.billing.repository

import com.jyx.billing.model.Item
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository: MongoRepository<Item, ObjectId> {
    fun findByBillId(billId: ObjectId): List<Item>
}