package com.Flashycards.Flashycards.utilities;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorsTest {

    @Test
    public void validate_password_test(){
        /**
         password_1 contains only lowercase => fails
         password_2 contains uppercase and lowercase => fails
         password_3 contains uppercase, lowercase, and number => fails
         password_4 contains uppercase, lowercase, number, and symbol => passes
         */

        //given
        String password_1 = "chung";
        String password_2 = "Chung";
        String password_3 = "Chung01";
        String password_4 = "Chung001.";

        //then
        Assert.assertFalse(Validators.validatePassword(password_1));
        Assert.assertFalse(Validators.validatePassword(password_2));
        Assert.assertFalse(Validators.validatePassword(password_3));

        Assert.assertTrue(Validators.validatePassword(password_4));
    }
}
