package com.example.mission7.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "region")
public class Region extends BaseEntity{
    String name;

    @OneToMany(mappedBy = "region")
    private List<Store> stores = new ArrayList<>();
}
