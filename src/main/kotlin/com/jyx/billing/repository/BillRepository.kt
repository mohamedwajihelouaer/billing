package com.jyx.billing.repository

import com.jyx.billing.model.Bill
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface BillRepository: MongoRepository<Bill, ObjectId> {
    fun findByCustomerId(customerId: ObjectId): List<Bill>
}