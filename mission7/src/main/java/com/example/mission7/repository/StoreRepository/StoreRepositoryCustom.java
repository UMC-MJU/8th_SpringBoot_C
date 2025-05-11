package com.example.mission7.repository.StoreRepository;

import com.example.mission7.domain.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}