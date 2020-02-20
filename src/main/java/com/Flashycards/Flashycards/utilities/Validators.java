package com.Flashycards.Flashycards.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    //A password must pass the regex which include a lowercase uppercase number and a symbol
    public static Boolean validatePassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
