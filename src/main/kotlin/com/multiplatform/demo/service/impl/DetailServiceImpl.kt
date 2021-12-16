package com.multiplatform.demo.service.impl

import com.multiplatform.demo.entity.Detail
import com.multiplatform.demo.model.DetailResponse
import com.multiplatform.demo.model.createDetailRequest
import com.multiplatform.demo.repository.DetailRepository
import com.multiplatform.demo.service.DetailService
import org.springframework.stereotype.Service

@Service
class DetailServiceImpl(val detailRepository: DetailRepository): DetailService{
    override fun create(detailRequest: createDetailRequest): DetailResponse {
        val detail = Detail(
            id = detailRequest.id,
            title = detailRequest.title,
            description = detailRequest.description
        )
        detailRepository.save(detail)

        return convertDetailtoDetailResponse(detail)
    }
    private fun convertDetailtoDetailResponse(detail: Detail): DetailResponse{
        return DetailResponse(
            id = detail.id,
                title = detail.title,
            description = detail.description
        )
    }
}