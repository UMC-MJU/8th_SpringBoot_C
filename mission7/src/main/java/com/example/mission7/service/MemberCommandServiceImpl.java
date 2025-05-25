package com.example.mission7.service;


import com.example.mission7.converter.MemberConverter;
import com.example.mission7.converter.MemberPreferConverter;
import com.example.mission7.domain.FoodCategory;
import com.example.mission7.domain.Member;
import com.example.mission7.domain.MemberPrefer;
import com.example.mission7.dto.request.MemberRequestDTO;
import com.example.mission7.exception.error.ErrorStatus;
import com.example.mission7.handler.TempHandler;
import com.example.mission7.repository.FoodCategoryRepository;
import com.example.mission7.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new TempHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}