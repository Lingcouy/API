package com.multiplatform.demo.controller

import com.multiplatform.demo.model.DetailResponse
import com.multiplatform.demo.model.WebResponse
import com.multiplatform.demo.model.createDetailRequest
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import com.multiplatform.demo.service.DetailService
import org.springframework.web.bind.annotation.PostMapping

@RestController
class DetailController(val detailService: DetailService) {

    @PostMapping(
        value = ["/api/detail"],
        produces = ["application/json"],
        consumes = ["application/json"]

    )
    fun createDetail(@RequestBody body: createDetailRequest): WebResponse<DetailResponse>{
        val detailResponse = detailService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = detailResponse
        )
    }
}