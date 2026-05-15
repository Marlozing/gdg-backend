package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;

import java.util.List;

public interface MemberRepository {
    Member findById(Long id);
    List<Member> findAll();
    Member findByLoginId(String loginId);
    void save(Member member);
    void deleteById(Long id);
}
