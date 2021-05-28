package com.company.dataaccess.abstracts;

import com.company.entities.concretes.Member;

import java.util.List;

public interface MemberDaoService {
    void add(Member member);
    void login(Member member);
    List<Member> getAll();
}
