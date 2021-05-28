package com.company.core.concretes;

import com.company.core.abctracts.AuthManagerService;
import com.company.core.abctracts.CheckManagerService;
import com.company.dataaccess.abstracts.MemberDaoService;
import com.company.googleservice.GoogleService;

public class GoogleServiceAdapter implements AuthManagerService {

    @Override
    public boolean checkEmail(String email) {
        GoogleService googleService = new GoogleService();
        return googleService.addWithEmail(email);
    }



}
