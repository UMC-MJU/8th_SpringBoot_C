package com.example.mission7.converter;

import com.example.mission7.domain.FoodCategory;
import com.example.mission7.domain.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .category(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
