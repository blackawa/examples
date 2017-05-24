package com.example.demo.repository

import com.example.demo.entity.LanguageEntity
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@ConfigAutowireable
@Dao
interface LanguageRepository {
    @Select
    fun findAll(): List<LanguageEntity>
}
