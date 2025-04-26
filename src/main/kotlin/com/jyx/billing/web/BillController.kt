package com.jyx.billing.web

import com.jyx.billing.model.Bill
import com.jyx.billing.repository.BillRepository
import org.bson.types.ObjectId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
@RequestMapping("/api/bills")
class BillController(
    private val repository: BillRepository
) {

    /**
     * request body
     */
    data class BillRequest(
        val id: String?,
        val description: String,
        val items: Map<String, Int>,
        val customerId: String
    )


    /**
     * Body response
     */
    data class BillResponse(
        val id: String,
        val description: String,
        val issuedAt: Instant,
        val items: Map<String, Int>,
        val customerId: ObjectId
    )

    @PostMapping
    fun save(
        @RequestBody body: BillRequest
    ): BillResponse {
        val aBill = repository.save(
            Bill(id = body.id?.let { ObjectId(it) } ?: ObjectId.get(),
            description = body.description,
            issuedAt = Instant.now(),
            items = body.items,
            customerId = ObjectId(
                body.customerId
            )))
        return aBill.toResponse()
    }

    @GetMapping
    fun findByCustomerId(
        @RequestParam(required = true) customerId: String
    ): List<BillResponse> {
        return repository.findByCustomerId(ObjectId(customerId)).map {
                it.toResponse()
            }
    }

}

/**
 * extension function: we extend the Existing Bill class here for this need
 * if this behavior needed in more than one spot make into mapper package
 */
private fun Bill.toResponse(): BillController.BillResponse {
    return BillController.BillResponse(
        id = id.toHexString(),
        description = description,
        issuedAt = issuedAt,
        items = items,
        customerId = customerId
    )
}
