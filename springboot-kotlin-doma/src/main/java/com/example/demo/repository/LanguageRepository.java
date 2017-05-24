package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Language;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@ConfigAutowireable
@Dao
public interface LanguageRepository {
    @Select
    List<Language> findAll();
}
