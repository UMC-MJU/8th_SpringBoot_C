package com.example.mission7.service;


import com.example.mission7.domain.Member;
import com.example.mission7.repository.MemberMissionRepository;
import com.example.mission7.repository.MemberPreferRepository;
import com.example.mission7.repository.MemberRepository;
import com.example.mission7.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberPreferRepository memberPreferRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void withdraw(UUID memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        memberMissionRepository.deleteByMemberId(memberId);
        memberPreferRepository.deleteByMemberId(memberId);
        memberRepository.delete(member);
    }
}
