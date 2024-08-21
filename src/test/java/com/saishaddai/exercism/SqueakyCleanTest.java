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
        assertEquals(SqueakyClean.kebabToCamel2("a-bc"), "aBc");
    }


    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns empty string when invoked on empty string")
    public void empty() {
        assertEquals(SqueakyClean.clean(""), "");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a single letter string")
    public void single_letter() {
        assertEquals(SqueakyClean.clean("A"), "A");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method returns the same string when invoked on a string of three letters")
    public void string() {
        assertEquals(SqueakyClean.clean("abc"), "abc");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces whitespaces with underscores in the middle of the string")
    public void spaces() {
        assertEquals(SqueakyClean.clean("my   Id"), "my___Id");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The clean method replaces leading and trailing whitespaces with underscores")
    public void leading_and_trailing_spaces() {
        assertEquals(SqueakyClean.clean(" myId "), "_myId_");
    }

/*
Task 2
 */

    @Test
    @Tag("task:2")
    @DisplayName("The clean method converts kebab to camel case after removing a dash")
    public void kebab_to_camel_case() {
        assertEquals(SqueakyClean.clean("a-bc"), "aBc");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case after removing a dash and replaces a whitespace")
    public void kebab_to_camel_case_and_number() {
        assertEquals(SqueakyClean.clean("a-C "), "aC_");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The clean method returns a string in camel case and replaces leading and trailing whitespaces")
    public void kebab_to_camel_case_and_spaces() {
        assertEquals(SqueakyClean.clean(" hello-world "), "_helloWorld_");
    }


    /*
    Task 3
     */
    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text after replacing numbers with chars")
    public void leetspeak_to_normal_text() {
        assertEquals(SqueakyClean.clean("H3ll0 W0rld"), "Hello_World");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The clean method converts leetspeak to normal text with spaces and special characters")
    public void leetspeak_to_normal_text_with_spaces_and_special_characters() {
        assertEquals(SqueakyClean.clean("¡1337sp34k is fun!"), "leetspeak_is_fun");
    }




    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters")
    public void special_characters() {
        assertEquals(SqueakyClean.clean("a$#.b"), "ab");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The clean method removes all characters that are not letters and replaces spaces")
    public void special_characters_and_spaces() {
        assertEquals(SqueakyClean.clean("¡hello world!. "),"hello_world_");
    }

}