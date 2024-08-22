package com.saishaddai.exercism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqueakyCleanTest {

    @Test
    @Tag("task:1")
    @DisplayName("kebab testing")
    public void kebab() {
        assertEquals("aBc", SqueakyClean.kebabToCamelCase("a-bc"));
    }


    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns empty string when invoked on empty string")
    public void empty() {
        assertEquals("", SqueakyClean.clean(""));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a single letter string")
    public void single_letter() {
        assertEquals("A", SqueakyClean.clean("A"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a string of three letters")
    public void string() {
        assertEquals("abc", SqueakyClean.clean("abc"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces whitespaces with underscores in the middle of the string")
    public void spaces() {
        assertEquals("my___Id", SqueakyClean.clean("my   Id"));
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces leading and trailing whitespaces with underscores")
    public void leading_and_trailing_spaces() {
        assertEquals("_myId_", SqueakyClean.clean(" myId "));
    }

/*
Task 2
 */

    @Test
    @Tag("task:2")
    @DisplayName("The clean method converts kebab to camel case after removing a dash")
    public void kebab_to_camel_case() {
        assertEquals("aBc", SqueakyClean.clean("a-bc"));
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case after removing a dash and replaces a whitespace")
    public void kebab_to_camel_case_and_number() {
        assertEquals("aC_", SqueakyClean.clean("a-C "));
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case and replaces leading and trailing whitespaces")
    public void kebab_to_camel_case_and_spaces() {
        assertEquals("_helloWorld_", SqueakyClean.clean(" hello-world "));
    }


    /*
    Task 3
     */
    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text after replacing numbers with chars")
    public void leetspeak_to_normal_text() {
        assertEquals("Hello_World", SqueakyClean.clean("H3ll0 W0rld"));
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text with spaces and special characters")
    public void leetspeak_to_normal_text_with_spaces_and_special_characters() {
        assertEquals("leetspeak_is_fun", SqueakyClean.clean("¡1337sp34k is fun!"));
    }




    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters")
    public void special_characters() {
        assertEquals("ab", SqueakyClean.clean("a$#.b"));
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters and replaces spaces")
    public void special_characters_and_spaces() {
        assertEquals("hello_world_", SqueakyClean.clean("¡hello world!. "));
    }

}