package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Float score;

    private String description;

    @ManyToOne
    @JoinColumn(name = "member_id")  // 외래키 컬럼명
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id")  // 외래키 컬럼명
    private Store store;


}