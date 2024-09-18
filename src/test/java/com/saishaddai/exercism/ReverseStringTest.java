package com.saishaddai.exercism;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReverseStringTest {

    @Test
    public void testAnEmptyString() {
        assertTrue(new ReverseString().reverse("").isEmpty());
    }

    @Test
    public void testAWord() {
        assertEquals("tobor", new ReverseString().reverse("robot"));
    }

    @Test
    public void testACapitalizedWord() {
        assertEquals("nemaR", new ReverseString().reverse("Ramen"));
    }
    
    @Test
    public void testASentenceWithPunctuation() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverse("I'm hungry!"));
    }
    
    @Test
    public void testAPalindrome() {
        assertEquals("racecar", new ReverseString().reverse("racecar"));
    }
    
    @Test
    public void testAnEvenSizedWord() {
        assertEquals("reward", new ReverseString().reverse("drawer"));
    }


    @Test
    public void testAnEmptyString_noLambdas() {
        assertTrue(new ReverseString().reverseNoLambda("").isEmpty());
    }

    @Test
    public void testAWord_noLambda() {
        assertEquals("tobor", new ReverseString().reverseNoLambda("robot"));
    }

    
    @Test
    public void testACapitalizedWord_noLambda() {
        assertEquals("nemaR", new ReverseString().reverseNoLambda("Ramen"));
    }
    
    @Test
    public void testASentenceWithPunctuation_noLambda() {
        assertEquals("!yrgnuh m'I", new ReverseString().reverseNoLambda("I'm hungry!"));
    }
    
    @Test
    public void testAPalindrome_noLambda() {
        assertEquals("racecar", new ReverseString().reverseNoLambda("racecar"));
    }
    
    @Test
    public void testAnEvenSizedWord_noLambda() {
        assertEquals("reward", new ReverseString().reverseNoLambda("drawer"));
    }
}