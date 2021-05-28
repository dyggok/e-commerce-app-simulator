package com.company.core.abctracts;

import com.company.entities.concretes.Member;

public interface CheckManagerService {
    boolean checkFirstName(String name);
    boolean checkLastName(String lname);
    boolean checkEmail(String email);
    boolean checkPassword(String password);
    boolean checkAllEmail(String email);
}
