package com.company.googleservice;

import com.company.entities.concretes.Member;

import java.util.regex.Matcher;

public class GoogleService {

    private static final String emailRegex = "^[\\w.+\\-]+@gmail\\.com$";


    public boolean addWithEmail(String email){
        boolean matcher = email.matches(emailRegex);
        return matcher;
    }
}
