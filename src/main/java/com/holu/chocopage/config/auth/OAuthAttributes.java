package com.holu.chocopage.config.auth;

import com.holu.chocopage.domain.member.entitiy.Member;
import com.holu.chocopage.domain.member.entitiy.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String id;
    private String name;
    private String email;
    private String profileImage;

    @Builder
    public OAuthAttributes(String id, Map<String, Object> attributes, String nameAttributeKey, String name, String email, String profileImage) {
        this.id = id;
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.profileImage = profileImage;
    }

    public static OAuthAttributes ofKakao(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");

        return OAuthAttributes.builder()
            .id((String) attributes.get("id"))
            .name((String) kakaoProfile.get("nickname"))
            .email((String) kakaoAccount.get("email"))
            .profileImage((String) kakaoProfile.get("profile_image_url"))
            .attributes(attributes)
            .nameAttributeKey(userNameAttributeName)
            .build();
    }

    public Member toEntity() {
        return Member.builder()
            .id(id)
            .name(name)
            .email(email)
            .profileImage(profileImage)
            .role(Role.USER)
            .build();
    }
}
