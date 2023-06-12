package com.holu.chocopage.domain.member.entitiy;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(generator = "memberId")
    @GenericGenerator(name = "memberId",
        type = MemberIdGenerator.class)
    @Column(name = "member_id")
    private String id;
    @Column(name = "member_name")
    private String name;

    @Builder
    public Member(String name) {
        this.name = name;
    }
}

