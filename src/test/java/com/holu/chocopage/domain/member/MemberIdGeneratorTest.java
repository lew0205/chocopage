package com.holu.chocopage.domain.member;

import com.holu.chocopage.domain.member.entitiy.Member;
import com.holu.chocopage.domain.member.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberIdGeneratorTest {
    @Autowired
    MemberRepository repository;

    @Test
    public void idGenerateTest() {
        //given
        Member member = new Member().builder()
            .name("testName")
            .build();
        //when
        String result = repository.save(member).getId();
        //then
        log.info(result);
        assertThat(result.length()).isEqualTo(9);
    }
}
