package com.vastika.ud.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class PasswordCheck {

    public boolean checkPassword(String password){

        String regrex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}";
        Pattern pattern  = Pattern.compile(regrex);
        Matcher matcher = pattern.matcher(password);
        boolean flag = matcher.matches();

        return flag;
    }

}
