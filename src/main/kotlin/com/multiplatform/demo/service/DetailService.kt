package com.multiplatform.demo.service

import com.multiplatform.demo.model.DetailResponse
import com.multiplatform.demo.model.ListDetailRequest
import com.multiplatform.demo.model.createDetailRequest

interface DetailService {
    fun create(detailRequest: createDetailRequest): DetailResponse

    fun listDetail(listDetailRequest: ListDetailRequest): List<DetailResponse>
}