package utils;

public class Validator {

    public static boolean notEmpty(String s) {
        return s != null && !s.trim().isEmpty();
    }
}