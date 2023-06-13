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
    @Column(name = "member_id")
    private String id;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_profileImage")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role", nullable = false)
    private Role role;

    @Builder
    public Member(String id, String name, String email, String profileImage, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
        this.role = role;
    }

    public Member update(String name, String profileImage) {
        this.name = name;
        this.profileImage = profileImage;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

