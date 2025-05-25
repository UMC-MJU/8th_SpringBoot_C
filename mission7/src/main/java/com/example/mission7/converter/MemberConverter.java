package com.example.mission7.converter;

import com.example.mission7.domain.Gender;
import com.example.mission7.domain.Member;
import com.example.mission7.dto.request.MemberRequestDTO;
import com.example.mission7.dto.response.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .spec_address(request.getSpecAddress())
                .gender(String.valueOf(gender))
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
