package com.saishaddai.exercism;

import java.util.stream.Collectors;


public class SqueakyClean {

    static String clean(String identifier) {
        if (identifier.isEmpty()) {
            return "";
        } else {
            return cleanInStream(kebabToCamelCase(identifier));
        }
    }

    private static String cleanInStream(String identifier) {
        return identifier.chars()
                .map(SqueakyClean::transformBlanks)//task 1
                .map(SqueakyClean::transformLeetspeak)//task 3
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(SqueakyClean::removeSymbols)//task 4
                .collect(Collectors.joining());
    }

    private static char transformBlanks(int c) {
        return c == ' ' ? '_' : (char) c;
    }

    private static char transformLeetspeak(int c) {
        char result;
        switch(c) {
            case '0':
                result = 'o';
                break;
            case '1':
                result = 'l';
                break;
            case '3':
                result = 'e';
                break;
            case '4':
                result = 'a';
                break;
            case '7':
                result = 't';
                break;
            default: result = (char) c;
        }
        return result;
    }


    static String kebabToCamelCase(String kebabString) {
        int startPosition = kebabString.indexOf("-");
        if (startPosition < 0)
            return kebabString;
        int nextWordPosition = startPosition + 1;
        StringBuilder sb = new StringBuilder(kebabString);
        String updateString = (sb.charAt(nextWordPosition)+"").toUpperCase();
        sb.replace(startPosition, nextWordPosition + 1, updateString);
        return sb.toString();
    }

    private static String removeSymbols(String string) {
        return string.replaceAll("[^a-zA-Z_]", "");
    }
}
