package com.example.mission7.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "member")
public class Member extends BaseEntity {
    String name;
    String gender;
    String address;
    String spec_address;
    String status;
    LocalDateTime inactivationDate;
    String social_type;
    String email;
    int point;
    int age;

    @OneToMany(mappedBy = "member", orphanRemoval = true)
    private List<MemberMission> memberMissions = new ArrayList<>();

    @OneToMany(mappedBy = "member", orphanRemoval = true)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Review> reviews = new ArrayList<>();

}
