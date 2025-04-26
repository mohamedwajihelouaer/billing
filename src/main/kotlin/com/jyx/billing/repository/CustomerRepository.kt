package com.jyx.billing.repository

import com.jyx.billing.model.Customer
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository: MongoRepository<Customer, ObjectId> {
}