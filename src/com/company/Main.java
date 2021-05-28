package com.company;

import com.company.business.abstracts.MemberManagerService;
import com.company.business.concretes.MemberManager;
import com.company.core.concretes.CheckManager;
import com.company.core.concretes.GoogleServiceAdapter;
import com.company.dataaccess.concretes.MemberDao;
import com.company.entities.concretes.Member;

public class Main {

    public static void main(String[] args) {
        //iki müşteri eklendi
        Member member = new Member("Duygu","Gök","xxx@gmail.com","12345654");
        Member member2 = new Member("Engin","Demirog","xxx@gmail.com","12345654");
        //aynı veri erişim sistemi kullanılarak google paketi eklendi
        MemberDao memberDao = new MemberDao();
        MemberManagerService memberManagerService = new MemberManager(new CheckManager(memberDao),memberDao,new GoogleServiceAdapter());
        //üye database'e eklendi
        memberManagerService.add(member);
        //sisteme giriş yapıldı
        memberManagerService.login(member);
        //bir başka üye aynı maili kullandığı için burada hata verdi
        memberManagerService.add(member2);

    }
}
