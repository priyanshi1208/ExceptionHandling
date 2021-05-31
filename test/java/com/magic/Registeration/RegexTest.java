package com.magic.Registeration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RegexTest {

    @org.junit.jupiter.api.Test
    public void validating_firstname_is_Not_Short()throws CustomException {
        try {
            Regex.firstName("Pr");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT,e.type);
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_firstname_is_Not_Null() {
        try {
            Regex.firstName(null);
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INPUT_IS_NULL,e.type);
            e.getMessage();
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_email_contains() {
        try {
            Regex.email("pri.shukla.com");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INVALID_INPUT,e.type);
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_email_is_valid() {
        try {
            Regex.email("pri.shukla@.com");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INVALID_INPUT,e.type);
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_password_is_not_short() {
        try {
            Regex.password("bunny2");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT,e.type);
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_password_is_valid() {
        try {
            Regex.password("bunny2123");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INVALID_INPUT,e.type);
        }
    }
    @org.junit.jupiter.api.Test
    public void validating_phoneNumber_valid() {
        try {
            Regex.phoneNumber("98765432");
        } catch (CustomException e) {
            Assert.assertEquals(CustomException.ExceptionType.INVALID_INPUT,e.type);
        }
    }
}