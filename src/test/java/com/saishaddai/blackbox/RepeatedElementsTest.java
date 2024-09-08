package com.saishaddai.blackbox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeatedElementsTest {

    @Test
    @Tag("firstApproach")
    @DisplayName("find first duplicate with null or empty list returns -1")
    void findFirstDuplicate_emptyOrNull() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate(null);
        assertEquals(-1, result);
        result  = re.findFirstDuplicate(List.of());
        assertEquals(-1, result);
    }

    @Test
    @Tag("firstApproach")
    @DisplayName("find first duplicate with no duplicates returns -1")
    void findFirstDuplicate_noDuplicates() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertEquals(-1, result);
    }


    @Test
    @Tag("firstApproach")
    @DisplayName("find first duplicate with multiple duplicates returns the first one")
    void findFirstDuplicate_multipleDuplicates() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate(List.of(1, 2, 9, 4, 5, 6, 7, 8, 9));
        assertEquals(9, result);
        result  = re.findFirstDuplicate(List.of(1, 2, 9, 5, 5, 6, 7, 8, 9));
        assertEquals(5, result);
    }

    @Test
    @Tag("secondApproach")
    @DisplayName("find first duplicate with null or empty list returns -1")
    void findFirstDuplicate2_emptyOrNull() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate2(null);
        assertEquals(-1, result);
        result  = re.findFirstDuplicate(List.of());
        assertEquals(-1, result);
    }

    @Test
    @Tag("secondApproach")
    @DisplayName("find first duplicate with no duplicates returns -1")
    void findFirstDuplicate2_noDuplicates() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate2(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertEquals(-1, result);
    }


    @Test
    @Tag("secondApproach")
    @DisplayName("find first duplicate with multiple duplicates returns the first one")
    void findFirstDuplicate2_multipleDuplicates() {
        RepeatedElements re = new RepeatedElements();
        var result  = re.findFirstDuplicate2(List.of(1, 2, 9, 4, 5, 6, 7, 8, 9));
        assertEquals(9, result);
        result  = re.findFirstDuplicate2(List.of(1, 2, 9, 5, 5, 6, 7, 8, 9));
        assertEquals(5, result);
    }

}