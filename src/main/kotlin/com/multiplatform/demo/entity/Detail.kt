package com.multiplatform.demo.entity

import javax.persistence.*

@Entity
@Table(name = "detail")
data class Detail(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,

    @Column(name ="R")
    val R: Int,

    @Column(name ="G" )
    val G: Int,

    @Column(name = "B")
    val B: Int,

    @Column(name = "pH")
    val pH: Int
)
