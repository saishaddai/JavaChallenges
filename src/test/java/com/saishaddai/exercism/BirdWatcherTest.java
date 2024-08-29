package com.saishaddai.exercism;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BirdWatcherTest {


    @Test
    @Tag("task:1")
    @DisplayName("The getLastWeek method correctly returns last week's counts")
    public void testTestGetLastWeek() {
        int[] view = { 4, 9, 7, 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        int[] lastWeek = birdWatcher.getLastWeek();
        assertEquals(7, lastWeek.length);
        assertEquals(1, lastWeek[4]);
        assertEquals(0, lastWeek[3]);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The today value method correctly returns the right number of the last entry in the array")
    public void testGetToday() {
        int[] view = { 4, 9, 7, 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        int viewsToday = birdWatcher.getToday();
        assertEquals(5, viewsToday);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The increment today's Count method correctly sums to today's number of views")
    public void testIncrementTodaysCount() {
        int[] view = { 4, 9, 7, 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        birdWatcher.incrementTodaysCount();
        assertEquals(6, birdWatcher.getToday());
    }


    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method correctly gets the number of entries with zero value")
    public void testHasDayWithoutBirds() {
        int[] view = { 4, 9, 7 , 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        boolean result = birdWatcher.hasDayWithoutBirds();
        assertTrue(result);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The count for first days method correctly sums first number of entries")
    public void testCountForFirstDays() {
        int[] view = { 4, 9, 7, 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        int result = birdWatcher.getCountForFirstDays(4);
        assertEquals(20, result);
    }


    @Test
    @Tag("task:6")
    @DisplayName("The get Busy Days method correctly gets the number of days which entry is bigger than 5")
    public void testGetBusyDays() {
        int[] view = { 4, 9, 7, 0, 1, 3, 5};
        BirdWatcher birdWatcher = new BirdWatcher(view);
        int result = birdWatcher.getBusyDays();
        assertEquals(3, result);
    }


}