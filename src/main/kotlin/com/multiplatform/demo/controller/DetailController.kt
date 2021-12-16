package com.multiplatform.demo.controller

import com.multiplatform.demo.model.DetailResponse
import com.multiplatform.demo.model.ListDetailRequest
import com.multiplatform.demo.model.WebResponse
import com.multiplatform.demo.model.createDetailRequest
import com.multiplatform.demo.service.DetailService
import org.springframework.web.bind.annotation.*

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

    @GetMapping(
        value = ["/api/detail"],
        produces = ["application/json"]
        )
    fun listDetail(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0")page: Int):WebResponse<List<DetailResponse>>{
        val request = ListDetailRequest(page = page, size = size)
        val response = detailService.listDetail(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}