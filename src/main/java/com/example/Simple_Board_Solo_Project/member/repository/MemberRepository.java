package com.example.Simple_Board_Solo_Project.member.repository;

import com.example.Simple_Board_Solo_Project.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
