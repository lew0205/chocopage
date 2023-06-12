package com.holu.chocopage.domain.member.repository;

import com.holu.chocopage.domain.member.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String > {
}
