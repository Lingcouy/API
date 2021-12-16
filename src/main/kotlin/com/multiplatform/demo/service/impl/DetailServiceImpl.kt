package com.multiplatform.demo.service.impl

import com.multiplatform.demo.entity.Detail
import com.multiplatform.demo.model.DetailResponse
import com.multiplatform.demo.model.ListDetailRequest
import com.multiplatform.demo.model.createDetailRequest
import com.multiplatform.demo.repository.DetailRepository
import com.multiplatform.demo.service.DetailService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class DetailServiceImpl(val detailRepository: DetailRepository): DetailService{
    override fun create(detailRequest: createDetailRequest): DetailResponse {
        val detail = Detail(
            id = detailRequest.id,
            R = detailRequest.R,
            G = detailRequest.G,
            B = detailRequest.B,
            pH = detailRequest.pH
        )
        detailRepository.save(detail)

        return convertDetailtoDetailResponse(detail)
    }

    override fun listDetail(listDetailRequest: ListDetailRequest): List<DetailResponse> {
        val page =detailRepository.findAll(PageRequest.of(listDetailRequest.page, listDetailRequest.size))
        val detail: List<Detail> = page.get().collect(Collectors.toList())

        return detail.map {
            convertDetailtoDetailResponse(it)
        }
    }

    private fun convertDetailtoDetailResponse(detail: Detail): DetailResponse{
        return DetailResponse(
            id = detail.id,
            R = detail.R,
            G = detail.G,
            B = detail.B,
            pH = detail.pH

        )
    }
}