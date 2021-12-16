package com.multiplatform.demo.entity

import javax.persistence.*

@Entity
@Table(name = "detail")
data class Detail(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,

    @Column(name ="title")
    val title: String,

    @Column(name ="description" )
    val description: String
)
