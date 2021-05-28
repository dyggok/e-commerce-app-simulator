package com.company.business.concretes;

import com.company.business.abstracts.MemberManagerService;
import com.company.core.abctracts.AuthManagerService;
import com.company.core.abctracts.CheckManagerService;
import com.company.dataaccess.abstracts.MemberDaoService;
import com.company.entities.concretes.Member;

import java.util.Scanner;

public class MemberManager implements MemberManagerService {
    private CheckManagerService checkManagerService;
    private MemberDaoService memberDaoService;
    private AuthManagerService authManagerService;

    public MemberManager(CheckManagerService checkManagerService, MemberDaoService memberDaoService, AuthManagerService authManagerService) {
        this.checkManagerService = checkManagerService;
        this.memberDaoService = memberDaoService;
        this.authManagerService = authManagerService;
    }

    @Override
    public void add(Member member) {
        checkManagerService.checkAllEmail(member.getEmail());
        if(checkManagerService.checkFirstName(member.getFirsName()) &&
        checkManagerService.checkLastName(member.getLastName()) &&
        authManagerService.checkEmail(member.getEmail()) &&
        checkManagerService.checkPassword(member.getPassword())){
           System.out.println(member.getFirsName()+" adlı üye başarılı bir şekilde sisteme kayıt olmuştur. " +
                    "Aktivasyon için linke tıklayınız.");
           activicationEmail();
            memberDaoService.add(member);
            System.out.println("Aktivasyon başarılı. Sisteme üye oldunuz!");
        }else{
            throw new RuntimeException("Girdiğiniz değerlere dikkat ediniz!");
        }
    }

    @Override
    public void login(Member member) {
       if(checkManagerService.checkEmail(member.getEmail()) &&
               checkManagerService.checkPassword(member.getPassword())){
           memberDaoService.login(member);
           System.out.println("Sisteme başarılı bir şekilde giriş yaptınız!");
       }else{
           throw new RuntimeException("Hatalı veya eksik giriş!");
       }
    }

    public void activicationEmail(){
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
