package com.basics.studentmanagementsystem.validation;

import com.basics.studentmanagementsystem.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
public class StudentValidations {
    private final Student student;

    //methods for validating input data

    public boolean validate() {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        String identificationNumber = student.getIdentificationNumber();


        return true;
    }

    public static boolean isStringNullorEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isFirstNameValid(String firstName) {
        if (isStringNullorEmpty(firstName)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        return pattern.matcher(firstName).matches();
    }

    public static boolean isLastNameValid(String lastName) {
        if (isStringNullorEmpty(lastName)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        return pattern.matcher(lastName).matches();
    }
    public static boolean isIdValid(String identificationNumber) {
        // Check if input is empty
        if (identificationNumber.isEmpty()) {
            return false;
        }

        // Validate using regular expression
        String regex = "^\\d{2}-?\\d{6,7}[A-Z]\\d{2}$";
        if (!identificationNumber.matches(regex)) {
            return false;
        }

        // Add hyphen if necessary
        if (identificationNumber.charAt(2) != '-') {
            identificationNumber = identificationNumber.substring(0, 2) + "-" + identificationNumber.substring(2);
        }

        // Return true for a valid identification number
        return true;
    }
}