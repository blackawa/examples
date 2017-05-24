package com.example.demo.entity

import org.seasar.doma.Entity
import org.seasar.doma.GeneratedValue
import org.seasar.doma.GenerationType
import org.seasar.doma.Id
import org.seasar.doma.ParameterName

@Entity(immutable = true)
data class Language(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ParameterName("id")
    val id: Long,
    @ParameterName("name")
    val name: String,
    @ParameterName("platform")
    val platform: String?
)
