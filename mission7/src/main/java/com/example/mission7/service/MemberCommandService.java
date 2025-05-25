package com.example.mission7.service;


import com.example.mission7.domain.Member;
import com.example.mission7.dto.request.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
