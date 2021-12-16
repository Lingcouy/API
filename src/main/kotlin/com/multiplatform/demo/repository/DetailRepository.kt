package com.multiplatform.demo.repository

import com.multiplatform.demo.entity.Detail
import org.springframework.data.jpa.repository.JpaRepository

interface DetailRepository:JpaRepository<Detail, Int> {
}