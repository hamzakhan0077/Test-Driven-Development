package com.example.javaasg3v11;

import org.junit.Test;
import com.example.javaasg3v11.HelloApplication;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class HelloApplicationTest {

    @Test
    public void testEmail() {
        String email0 = "johndoe@gmail.com";
        String email1 = "johndoegmail.com";
        String email2 = "johndoe@gmailcom";

        Assertions.assertTrue(HelloApplication.emailChecker(email0));
        Assertions.assertFalse(HelloApplication.emailChecker(email1));
        Assertions.assertFalse(HelloApplication.emailChecker(email2));
    }

    @Test
    public void testPassword() {
        String password0 = "Qwert5@";
        String password1 = "Qwet5@"; // < 7 chars
        String password2 = "Qwert55"; // no special character
        String password3= "qwert5@"; // no uppercase
        String password4= "Qwertt@"; // no Number
        String password5 = "Qwert$";// Special Character other than *^&@!

        Assertions.assertTrue(HelloApplication.passwordChecker(password0));
        Assertions.assertFalse(HelloApplication.passwordChecker(password1));
        Assertions.assertFalse(HelloApplication.passwordChecker(password2));
        Assertions.assertFalse(HelloApplication.passwordChecker(password3));
        Assertions.assertFalse(HelloApplication.passwordChecker(password4));
        Assertions.assertFalse(HelloApplication.passwordChecker(password5));


    }


}