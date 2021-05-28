package com.company.business.abstracts;

import com.company.entities.concretes.Member;

public interface MemberManagerService {
    void add(Member member);
    void login(Member member);
}
