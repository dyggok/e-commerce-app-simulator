package com.company.dataaccess.concretes;

import com.company.dataaccess.abstracts.MemberDaoService;
import com.company.entities.concretes.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDao implements MemberDaoService {
    private List<Member> members = new ArrayList<Member>();

    @Override
    public void add(Member member) {
        this.members.add(member);
    }

    @Override
    public void login(Member member) {

    }

    @Override
    public List<Member> getAll() {
        return this.members;
    }


}
