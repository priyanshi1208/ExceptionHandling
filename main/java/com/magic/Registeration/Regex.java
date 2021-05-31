package com.magic.Registeration;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String firstName,lastName,email,phoneNumber,password;
        do {
            System.out.println("Enter first name");
            firstName = scanner.next();
            firstName(firstName);
        }while(!firstName(firstName));
        do {
            System.out.println("Enter last name");
            lastName = scanner.next();
            lastName(lastName);
        }while(!lastName(lastName));
        do {
            System.out.println("Enter email");
            email = scanner.next();
            lastName(email);
        }while(!email(email));
        do {
            System.out.println("Enter phone Number");
            phoneNumber = scanner.next();
            lastName(phoneNumber);
        }while(!phoneNumber(phoneNumber));
        do {
            System.out.println("Enter password");
            password = scanner.next();
            lastName(password);
        }while(!password(password));
        System.out.println("Registeration successful");
    }
    public static boolean regexCheck(String reg, String input){
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(input);
        boolean matches=matcher.matches();
        return matches;
    }
    public static boolean firstName(String firstName) throws CustomException{
           try {
               String reg = "^[A-Z][a-z]{3,}";
               if (firstName.length() <= 3)
                   throw new CustomException("Input too short", CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT);
               if(regexCheck(reg, firstName))
                   return true;
               else
                   throw new CustomException("Invalid input",CustomException.ExceptionType.INVALID_INPUT);
           }
           catch(NullPointerException e){
               throw new CustomException("Input is Null",CustomException.ExceptionType.INPUT_IS_NULL);
           }
           catch(CustomException e) {
               e.printStackTrace();
           }
           return false;
    }
    public static boolean lastName(String lastName) {
            try {
                String reg = "^[A-Z][a-z]{3,}";
                if (lastName.length() <= 3)
                    throw new CustomException("Input too short", CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT);
                if(regexCheck(reg, lastName))
                    return true;
                else
                    throw new CustomException("Invalid input",CustomException.ExceptionType.INVALID_INPUT);
            }
            catch(NullPointerException e){
                throw new CustomException("Input is Null",CustomException.ExceptionType.INPUT_IS_NULL);
            }
            catch(CustomException e) {
                e.printStackTrace();
            }
            return false;
    }
    public static boolean email(String email) {
        try {
            String reg = "^[a-za-z0-9-\\+]+(\\.[a-za-z0-9-]+)*@"+"[a-za-z0-9-]+(\\.[a-za-z0-9]+)*(\\.[a-za-z]{2,})$";
           if(!email.contains("@"))
               throw new CustomException("Input does not match",CustomException.ExceptionType.INVALID_INPUT);
           if( regexCheck(reg,email))
                return true;
            else
                throw new CustomException("Enter valid email",CustomException.ExceptionType.INVALID_INPUT);
        }
        catch(CustomException e){
            e.printStackTrace();
            return false;
        }

    }
    public static boolean phoneNumber(String phoneNumber) {

        try {
            String reg = "[\\d]{2}[ ]?[\\d]{10}";
            if(phoneNumber.length()<10)
                throw new CustomException("Input is too short",CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT);
            if( regexCheck(reg,phoneNumber))
                return true;
            else
                throw new CustomException("Enter valid phone number",CustomException.ExceptionType.INVALID_INPUT);
        }
        catch(CustomException e){
            e.printStackTrace();
            return false;
        }

    }
    public static boolean password(String password) {
        try {
            String reg = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*-+=()]).{8,}$";
            if(password.length()<8)
                throw new CustomException("Password length too short",CustomException.ExceptionType.INPUT_LENGTH_IS_SHORT);
            if( regexCheck(reg,password))
                return true;
            else
                throw new CustomException("Enter valid password",CustomException.ExceptionType.INVALID_INPUT);
        }
        catch(CustomException e){
            e.printStackTrace();
            return false;
        }
    }

}

