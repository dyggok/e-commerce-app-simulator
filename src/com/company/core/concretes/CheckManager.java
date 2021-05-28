package com.company.core.concretes;

import com.company.core.abctracts.CheckManagerService;
import com.company.dataaccess.abstracts.MemberDaoService;
import com.company.dataaccess.concretes.MemberDao;
import com.company.entities.concretes.Member;

public class CheckManager implements CheckManagerService {
    private static final String firstNameRegex = "^.{2,}([a-z])$";
    private static final String lastNameRegex = "^.{2,}([a-z])$";
    private static final String emailRegex = "^(.+)@(.+)$";
    private static final String passwordRegex = "^.{8,}$";
    private MemberDaoService memberDaoService;

    public CheckManager(MemberDaoService memberDaoService) {
        this.memberDaoService = memberDaoService;
    }

    @Override
    public boolean checkFirstName(String firsName) {
        boolean matcher = firsName.matches(firstNameRegex);
        return matcher;
    }

    @Override
    public boolean checkLastName(String lastName) {
        boolean matcher = lastName.matches(lastNameRegex);
        return matcher;
    }

    @Override
    public boolean checkEmail(String email) {
            boolean matcher = email.matches(emailRegex);
            return matcher;

    }

    @Override
    public boolean checkPassword(String password) {
        boolean matcher = password.matches(passwordRegex);
        return matcher;
    }

    @Override
    public boolean checkAllEmail(String email) {
            for (Member member : memberDaoService.getAll()) {
                if (member.getEmail() == email) {
                    throw new RuntimeException("Bu email kullanılmış bir emaildir. Başka bir email kullanınız!");
                }
            }
        return true;
    }


}
